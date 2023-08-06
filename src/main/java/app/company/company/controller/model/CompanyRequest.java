package app.company.company.controller.model;

import com.google.gson.Gson;

public class CompanyRequest {
    private static final Gson gson = new Gson();
    private String name;
    private Field field;

    public CompanyRequest(String name, Field field) {
        this.name = name;
        this.field = field;
    }

    public CompanyRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
