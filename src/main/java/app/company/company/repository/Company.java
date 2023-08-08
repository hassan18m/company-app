package app.company.company.repository;

import app.company.company.controller.model.Field;
import app.company.employee.repository.Employee;
import com.google.gson.Gson;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "company")
public class Company {
    private static final Gson gson = new Gson();
    @Id
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private Field field;
    private int requiredExperience;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList = new ArrayList<>();

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
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

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        employee.setCompany(this);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
        employee.setCompany(null);
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
