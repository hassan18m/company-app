package app.company.company.service;

import app.company.company.controller.model.CompanyRequest;
import app.company.company.controller.model.CompanyResponse;
import app.company.company.controller.model.Field;
import app.company.company.repository.Company;
import app.company.company.repository.CompanyRepository;
import app.company.employee.controller.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        Company company = requestToEntity(companyRequest);
        companyRepository.save(company);
        logger.info("Persisted new company with data: {}", company);
        return entityToResponse(company);
    }

    public CompanyResponse findById(String id) {
        Company company = companyRepository.findById(id).orElseThrow(RuntimeException::new);
        return entityToResponse(company);
    }

    public CompanyResponse findByName(String name) {
        Company company = companyRepository.findByName(name).orElseThrow(RuntimeException::new);
        return entityToResponse(company);
    }

    public Company findByField(Field fieldName) {
        List<Company> companyList = companyRepository.findByField(fieldName);
        return companyList.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Company> findByRequiredExperience(int experience) {
        return companyRepository.findByRequiredExperience(experience);
    }

    public void deleteById(String id) {
        companyRepository.findById(id).orElseThrow(() -> {
            logger.info("No company with id: {} found", id);
            return new NotFoundException("Company with id " + id + " not found in database.");
        });

        companyRepository.deleteById(id);
        logger.info("Company with id: {} successfully removed.", id);
    }


    private static CompanyResponse entityToResponse(Company company) {
        return new CompanyResponse(
                company.getName(),
                company.getField(),
                company.getRequiredExperience(),
                company.getNoOfEmployees()
        );
    }

    private static Company requestToEntity(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setField(companyRequest.getField());
        company.setRequiredExperience(companyRequest.getRequiredExperience());
        company.setNoOfEmployees(companyRequest.getNoOfEmployees());
        return company;
    }
}
