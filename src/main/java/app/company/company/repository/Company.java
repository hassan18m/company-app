package app.company.company.repository;

import app.company.company.controller.model.Field;
import app.company.employee.repository.Employee;
import com.google.gson.Gson;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "company")
@EntityListeners(CompanyListener.class)
public class Company {
    private static final Gson gson = new Gson();
    @Id
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private Field field;
    private int requiredExperience;

    // This field is transient and not persisted in the database
    private Integer noOfEmployees;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

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

    // Getter and setter for noOfEmployees
    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
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
        // Exclude employeeList from serialization
        Company copy = new Company();
        copy.setName(name);
        copy.setField(field);
        copy.setRequiredExperience(requiredExperience);
        copy.setNoOfEmployees(getNoOfEmployees());
        return gson.toJson(copy);
    }
}