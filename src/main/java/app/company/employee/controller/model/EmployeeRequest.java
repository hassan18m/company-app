package app.company.employee.controller.model;

import app.company.company.repository.Occupation;
import com.google.gson.Gson;

public class EmployeeRequest {
    private static final Gson gson = new Gson();

    private String firstName;
    private String lastName;
    private String workEmail;
    private String phoneNumber;
    private Occupation occupation;
    private int experience;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String firstName, String lastName, String workEmail, String phoneNumber, Occupation occupation, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.workEmail = workEmail;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.experience = experience;
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
