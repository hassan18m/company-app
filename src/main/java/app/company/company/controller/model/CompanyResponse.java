package app.company.company.controller.model;

public class CompanyResponse extends CompanyRequest {

    public CompanyResponse(String name, Field field, int requiredExperience, int noOfEmployees) {
        super(name, field, requiredExperience, noOfEmployees);
    }

    public CompanyResponse() {
    }
}
