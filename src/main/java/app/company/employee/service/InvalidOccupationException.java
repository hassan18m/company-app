package app.company.employee.service;

public class InvalidOccupationException extends RuntimeException {
    public InvalidOccupationException(String occupation) {
        super("Invalid occupation: " + occupation);
    }
}

