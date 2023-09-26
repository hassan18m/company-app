package app.company.employee.service;

import app.company.company.controller.model.Field;
import app.company.company.repository.Occupation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeAssignment {

    static final Map<Field, List<Occupation>> fieldOccupationMap = new HashMap<>();

    static {
        fieldOccupationMap.put(Field.IT, List.of(Occupation.DESIGN_SPECIALIST, Occupation.NETWORKING_ENGINEER, Occupation.SOFTWARE_DEVELOPER));
        fieldOccupationMap.put(Field.POLITICS, List.of(Occupation.MAYOR, Occupation.FIREFIGHTER));
        fieldOccupationMap.put(Field.EDUCATION, List.of(Occupation.DOCTOR, Occupation.POLICE_OFFICER));
        fieldOccupationMap.put(Field.SALES,List.of(Occupation.SALESMAN));
        fieldOccupationMap.put(Field.MAINTENANCE,List.of(Occupation.ELECTRICIAN,Occupation.MECHANIC));
        fieldOccupationMap.put(Field.ACCOUNTING,List.of(Occupation.ACCOUNTANT,Occupation.BANKER));

    }
}
