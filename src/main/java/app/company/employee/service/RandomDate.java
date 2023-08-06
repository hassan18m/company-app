package app.company.employee.service;

import java.time.LocalDate;

public class RandomDate {
    public static LocalDate getRandomDate() {
        int randomDay = (int) (Math.random() * 30) + 1;
        int randomMonth = (int) (Math.random() * 12) + 1;
        int randomYear = (int) (Math.random() * 24) + 2000;

        return LocalDate.of(randomYear, randomMonth, randomDay);
    }
}
