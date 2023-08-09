package app.company.company.repository;

import jakarta.persistence.*;

public class CompanyListener {

    @PrePersist
    public static void onPrePersist(Company company) {
        if (!company.getEmployeeList().isEmpty()) {
            company.setNoOfEmployees(company.getEmployeeList().size());
        }
    }

    @PreRemove
    public static void onPreRemove(Company company) {
        if (!company.getEmployeeList().isEmpty()) {
            company.setNoOfEmployees(company.getEmployeeList().size() - 1);
        }
    }
}

