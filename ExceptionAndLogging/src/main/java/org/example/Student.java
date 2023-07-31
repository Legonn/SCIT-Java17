package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Student {

    enum Gender {
        Male,
        Female
    }

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String cnp;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String cnp) throws ValidationException {
        if (firstName.isBlank()) {
            throw new ValidationException("First name shouldn't be blank");
        } else {
            this.firstName = firstName;
        }
        if (lastName.isBlank()) {
            throw new ValidationException("Last name shouldn't be blank");
        } else {
            this.lastName = lastName;
        }
        if (dateOfBirth.getYear() < 1900 || LocalDate.now().minusYears(18).compareTo(dateOfBirth) < 0) {
            throw new ValidationException("Date of birth must be between 1900 and " + LocalDate.now().minusYears(18));
        } else {
            this.dateOfBirth=dateOfBirth;
        }
        this.gender = switch (gender.toLowerCase()) {
            case "male", "m" -> Gender.Male;
            case "female", "f" -> Gender.Female;
            default -> throw new ValidationException("Gender must be either Male or Female");
        };
        this.cnp = cnp;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", cnp=" + cnp +
                '}';
    }
}
