package serenity.ensure;

import java.time.LocalDate;
import java.time.Period;

public class Pet {
    private final String name;
    private final LocalDate dateOfBirth;

    public Pet(String name, LocalDate dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
