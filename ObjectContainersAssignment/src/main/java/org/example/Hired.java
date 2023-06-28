package org.example;

public class Hired extends Person{

    private double salary;
    private String employer;


    public Hired(String name, int age, String cnp, double salary, String employer) {
        super(name, age,cnp);
        this.salary = salary;
        this.employer = employer;
    }
}
