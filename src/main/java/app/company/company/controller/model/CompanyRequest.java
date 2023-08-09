package app.company.company.controller.model;

import com.google.gson.Gson;

public class CompanyRequest {
    private static final Gson gson = new Gson();
    private String name;
    private Field field;
    private int requiredExperience;
    private int noOfEmployees;

    public CompanyRequest(String name, Field field,int requiredExperience,int noOfEmployees) {
        this.name = name;
        this.field = field;
        this.requiredExperience=requiredExperience;
        this.noOfEmployees = noOfEmployees;
    }

    public CompanyRequest() {
    }

    public int getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(int noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
