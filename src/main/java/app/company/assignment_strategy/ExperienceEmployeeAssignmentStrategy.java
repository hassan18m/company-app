package app.company.assignment_strategy;

import app.company.company.repository.Company;
import app.company.employee.repository.Employee;

public class ExperienceEmployeeAssignmentStrategy implements EmployeeAssignmentStrategy{
    @Override
    public void assignEmployeeToCompany(Employee employee, Company company) {
        if(employee.getExperience() >=company.getRequiredExperience()){
            company.addEmployee(employee);
        }
    }
}
