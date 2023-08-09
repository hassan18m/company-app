package app.company.company.repository;

import jakarta.persistence.*;

public class CompanyListener {

    @PrePersist
    public void onPrePersist(Company company) {
        System.out.println("onPrePersist: Company " + company.getName() + " created");
        if (!company.getEmployeeList().isEmpty()) {
            company.setNoOfEmployees(company.getEmployeeList().size());
        }
    }

    @PreRemove
    public void onPreRemove(Company company) {
        System.out.println("onPreRemove: Company " + company.getName() + " removed");
        if (!company.getEmployeeList().isEmpty()) {
            company.setNoOfEmployees(company.getEmployeeList().size() - 1);
        }
    }
}

