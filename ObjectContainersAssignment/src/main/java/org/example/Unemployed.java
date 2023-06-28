    package org.example;

    public class Unemployed extends Person{

       private String sourceOfIncome;

        public Unemployed(String name, int age, String cnp, String sourceOfIncome) {
            super(name, age,cnp);
            this.sourceOfIncome = sourceOfIncome;
        }
    }
