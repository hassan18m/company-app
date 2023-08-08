package app.company.company.controller.model;

import com.google.gson.Gson;

public class CompanyRequest {
    private static final Gson gson = new Gson();
    private Field field;
    private int requiredExperience;

    public CompanyRequest(Field field,int requiredExperience) {
        this.field = field;
        this.requiredExperience=requiredExperience;
    }

    public CompanyRequest() {
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
