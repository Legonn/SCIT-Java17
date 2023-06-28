package org.example;

import java.util.Objects;
record Country(String continent,String countryName){

    @Override
    public String toString() {
        return continent + " " + countryName;
    }

}

public class Address{

    private String addressName;
    private int addressNumber;
    private Country country;

    public Address(String addressName, int addressNumber, Country country) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return addressNumber == address.addressNumber && Objects.equals(addressName, address.addressName) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressName, addressNumber, country);
    }

    @Override
    public String toString() {
        return country + ": " +addressName +" " +addressNumber;
    }
}

