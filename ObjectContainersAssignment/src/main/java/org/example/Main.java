package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Country country = new Country("Europe", "Romania");
        Country country1 = new Country("Europe", "Italy");
        Country country2 = new Country("Europe", "Greece");
        Country country3 = new Country("Europe", "Hungary");
        Country country4 = new Country("Europe", "Sweden");
        Country country5 = new Country("Europe", "United Kingdom");

        Hobby hobby = new Hobby("Swimming", 1);
        Hobby hobby1 = new Hobby("Fishing", 2);
        Hobby hobby2 = new Hobby("Biking", 3);
        Hobby hobby3 = new Hobby("Camping", 1);
        Hobby hobby4 = new Hobby("E-sports", 2);
        hobby.addAddresses(new Address("Plaza Romano", 42, country1));
        hobby.addAddresses(new Address("London Square", 132, country5));
        hobby.addAddresses(new Address("Odos Agrotikos", 37, country2));
        hobby1.addAddresses(new Address("Strada Pravaliei", 180, country));
        hobby1.addAddresses(new Address("Miplezki", 320, country3));
        hobby3.addAddresses(new Address("Odos Agrotikos", 37, country2));
        hobby3.addAddresses(new Address("Strada Pravaliei", 180, country));
        hobby4.addAddresses(new Address("Teodor Mihali", 39, country));
        hobby2.addAddresses(new Address("Plaza Romano", 42, country1));
        hobby2.addAddresses(new Address("Odos Agrotikos", 37, country2));


        Person person1 = new Hired("Alex", 26, "1970442332", 4200.50, "Yardi");
        Person person4 = new Hired("Alex", 26, "1970442332", 4200.50, "Yardi");
        Person person5 = new Hired("Alex", 25, "1970442333", 4200.50, "Yardi");
        Person person2 = new Unemployed("Marius", 30, "1930034438", "Financial aid");
        Person person3 = new Student("Andreea", 21, "2020032134", 3, "Universitatea Tehnica");

        person1.addHobby(hobby);
        person1.addHobby(hobby3);
        person1.addHobby(hobby4);


        person2.addHobby(hobby);
        person2.addHobby(hobby1);
        person2.addHobby(hobby2);
        person3.addHobby(hobby3);
        person3.addHobby(hobby4);
        person3.addHobby(hobby4);


        Set<Person> personSet = new TreeSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person2);
        personSet.add(person4);
        personSet.add(person5);
        Iterator<Person> iterator = personSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashMap<Person, List<Hobby>> hobbiesMap = new HashMap<>();
        hobbiesMap.put(person1, List.of(hobby, hobby3, hobby4));
        hobbiesMap.put(person1, List.of(hobby, hobby3, hobby4));
        hobbiesMap.put(person2, List.of(hobby, hobby1, hobby2));
        hobbiesMap.put(person3, List.of(hobby4, hobby3, hobby4));

        for (Person item : hobbiesMap.keySet()) {
            if (item == person1) {
                System.out.println(item.getName() + "'s list of hobbies:");
                System.out.println("-".repeat(40));
                for (List<Hobby> hobbies : hobbiesMap.values()) {
                    for (Hobby element : hobbies) {
                        for (Address address : element.getAddresses()) {
                            System.out.println(element + "\n" + " Location: " + address.getCountry().countryName());
                        }
                    }
                }
            }
        }
    }
}