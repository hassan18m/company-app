package app.company.employee.repository;

import app.company.company.repository.Company;
import app.company.company.repository.Occupation;
import app.company.employee.controller.exceptions.NotFoundException;
import jakarta.persistence.*;
import com.google.gson.Gson;

import java.time.LocalDate;

@Entity(name = "employee")
public class Employee {
    private static final Gson gson = new Gson();
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String workEmail;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column
    private Occupation occupation;
    private LocalDate startDate;
    private int experience;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_name")
    private Company company;
    @Transient
    private String companyName;
    public String getCompanyName() {
        if (company != null) {
            return company.getName();
        }
        throw new NotFoundException("Company not found");
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        Employee copy = new Employee();
        copy.setId(id);
        copy.setFirstName(firstName);
        copy.setLastName(lastName);
        copy.setWorkEmail(workEmail);
        copy.setPhoneNumber(phoneNumber);
        copy.setOccupation(occupation);
        copy.setExperience(experience);
        copy.setStartDate(startDate);
        copy.setCompanyName(getCompanyName());
        return gson.toJson(copy);
    }
}