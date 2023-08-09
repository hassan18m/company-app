package app.company.employee.controller.model;

import app.company.company.repository.Occupation;

public class EmployeeResponse extends EmployeeRequest {
    private String id;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String id) {
        this.id = id;
    }

    public EmployeeResponse(String id, String firstName, String lastName, String workEmail, String phoneNumber, Occupation occupation, int experience, String companyName) {
        super(firstName, lastName, workEmail, phoneNumber, occupation, experience, companyName);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
