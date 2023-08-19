package app.company.employee.controller.model;

import app.company.company.repository.Occupation;
import com.google.gson.Gson;
import jakarta.validation.constraints.*;

public class EmployeeRequest {
    private static final Gson gson = new Gson();

    private String firstName;
    private String lastName;
    @Email
    private String workEmail;
    @Pattern(regexp = "^\\+40[1-9][0-9]{8}$")
    private String phoneNumber;
    private Occupation occupation;
    @Min(0)
    private int experience;
    private String companyName;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String firstName, String lastName, String workEmail, String phoneNumber, Occupation occupation, int experience, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workEmail = workEmail;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.experience = experience;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
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

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
