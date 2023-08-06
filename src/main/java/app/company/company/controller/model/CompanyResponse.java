package app.company.company.controller.model;

public class CompanyResponse extends CompanyRequest {
    private String id;

    public CompanyResponse(String id, String name, Field field) {
        super(name, field);
        this.id = id;
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
