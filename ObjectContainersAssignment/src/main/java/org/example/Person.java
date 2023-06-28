package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String cnp;

    private List<Hobby> hobbies;

    public Person(String name, int age,String cnp) {
        this.name = name;
        this.age = age;
        this.cnp=cnp;
        this.hobbies=new ArrayList<Hobby>();
    }

    public String getName() {
        return name;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void addHobby( Hobby hobby){
        if (findHobby(hobby)==null){
            hobbies.add(hobby);
        }
    }


    private Hobby findHobby(Hobby hobby){
        if (hobbies.contains(hobby)){
            return hobby;
        }
        return null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(cnp, person.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    @Override
    public int compareTo(Person o) {
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.age, o.age);
    }
    @Override
    public String toString() {
        return "name: " + name +" age:" +age;
    }

}
