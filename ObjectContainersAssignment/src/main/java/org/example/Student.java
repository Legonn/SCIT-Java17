package org.example;

public class Student extends Person{

    private int currentUniversityYear;
    private String university;

    public Student(String name, int age, String cnp, int currentUniversityYear, String university) {
        super(name, age,cnp);
        this.currentUniversityYear = currentUniversityYear;
        this.university = university;
    }
}
