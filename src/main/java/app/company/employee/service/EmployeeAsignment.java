package app.company.employee.service;

import app.company.company.controller.model.Field;
import app.company.company.repository.Occupation;
import app.company.employee.repository.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EmployeeAsignment {
    private static final List<Occupation> itOccupationList = Arrays.asList(Occupation.DESIGN_SPECIALIST,
            Occupation.NETWORKING_ENGINEER,
            Occupation.SOFTWARE_DEVELOPER);
    private static final List<Occupation> salesOccupationList = Arrays.asList(Occupation.SALESMAN);
    private static final List<Occupation> politicsOccupationList = Arrays.asList(Occupation.MAYOR,
            Occupation.FIREFIGHTER);
    private static final List<Occupation> educationOccupationList = Arrays.asList(Occupation.DOCTOR,
            Occupation.POLICE_OFFICER,
            Occupation.FIREFIGHTER);

    public Map<Field, List<Occupation>> itJobAsignment = Map.of(Field.IT, itOccupationList);
    public Map<Field, List<Occupation>> politicsJobAsignment = Map.of(Field.POLITICS, politicsOccupationList);
    public Map<Field, List<Occupation>> educationJobAsignment = Map.of(Field.EDUCATION, educationOccupationList);

    public void assignEmployeeToCompany(Employee employee){

    }
}
