package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hobby {


    private String name;
    private int frequency;

    private List<Address> addresses;

    public Hobby(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = new ArrayList<Address>();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddresses(Address address){
        if (findAddress(address) ==null){
            addresses.add(address);
        }else {
            System.out.println("Found duplicate");
        }
    }

    private Address findAddress(Address address){
        for(Address address1: addresses ){
            if (address1.equals(address)){
                return address;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hobby hobby)) return false;
        return Objects.equals(name, hobby.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return  name + ", frequency: " + frequency + " time(s) per week";
    }
}
