package app.company.employee.service;


import app.company.company.repository.Company;
import app.company.company.repository.CompanyRepository;
import app.company.employee.controller.exceptions.NotFoundException;
import app.company.employee.controller.model.EmployeeRequest;
import app.company.employee.controller.model.EmployeeResponse;
import app.company.employee.repository.DuplicateDataException;
import app.company.employee.repository.Employee;
import app.company.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        String requestEmail = employeeRequest.getWorkEmail();
        String requestPhoneNumber = employeeRequest.getPhoneNumber();

        if (employeeRepository.existsByWorkEmail(requestEmail) ||
                employeeRepository.existsByPhoneNumber(requestPhoneNumber)) {
            throw new DuplicateDataException("Email or phone number already in DB.");
        }

        Employee employee = requestToEntity(employeeRequest);

        employeeRepository.save(employee);
        assignEmployeeToCompany(employee);
        logger.info("Persisted new employee with data: {}", employee);
        return entityToResponse(employee);
    }

    public EmployeeResponse getEmployeeByEmail(String email) {
        try {
            Employee employee = employeeRepository.getEmployeeByWorkEmail(email);
            return entityToResponse(employee);
        } catch (Exception e) {
            logger.info("Data not found in DB: {}", email);
            throw new NotFoundException("The email provided is not in our database.");
        }
    }

    public EmployeeResponse getById(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee with ID " + employeeId + " not found"));

        return entityToResponse(employee);
    }

    public void deleteEmployeeById(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new NotFoundException("Employee with ID " + id + " not found");
        }

        employeeRepository.deleteById(id);
    }

    public EmployeeResponse updateEmail(String employeeId, String newEmail) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> {
                    logger.info("Employee with id: {} not found in DB", employeeId);
                    return new NotFoundException("There is no employee with ID: " + employeeId);
                });

        employee.setWorkEmail(newEmail);
        employeeRepository.save(employee);

        return entityToResponse(employee);
    }

    private void assignEmployeeToCompany(Employee employee) {
        List<Company> matchingCompanies = companyRepository.findByRequiredExperience(employee.getExperience());

        if (!matchingCompanies.isEmpty()) {
            Company selectedCompany = matchingCompanies.get(0); // You can implement more complex selection logic here
            selectedCompany.addEmployee(employee);
            companyRepository.save(selectedCompany);
        }
    }

    private static EmployeeResponse entityToResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getWorkEmail(),
                employee.getPhoneNumber(),
                employee.getOccupation(),
                employee.getExperience()
        );
    }

    private static Employee requestToEntity(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString().substring(1, 8));
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setWorkEmail(employeeRequest.getWorkEmail());
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());
        employee.setOccupation(employeeRequest.getOccupation());
        employee.setExperience(employeeRequest.getExperience());
        employee.setStartDate(RandomDate.getRandomDate());
        return employee;
    }
}
