package app.company.company.controller.model;

public class CompanyResponse extends CompanyRequest {
    private String name;

    public CompanyResponse(String name, Field field, int requiredExperience) {
        super(name, field, requiredExperience);
        this.name = name;
    }

    public CompanyResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
