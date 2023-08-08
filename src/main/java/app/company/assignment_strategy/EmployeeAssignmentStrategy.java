package app.company.assignment_strategy;

import app.company.company.repository.Company;
import app.company.employee.repository.Employee;

public interface EmployeeAssignmentStrategy {
    void assignEmployeeToCompany(Employee employee, Company company);
}
