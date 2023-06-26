package org.example;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

record Message(String content){

    public Message(String content){
        if (content.length()>500){
            this.content=content.substring(0,500);
        }else {
            this.content=content;
        }
    }

    @Override
    public String toString() {
        return "Message: " +
                content;
    }
}

public class Contact{
    protected int indexNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    protected LinkedList<Message> messages;


    public Contact( String firstName, String lastName, String phoneNumber) {
        this.indexNumber = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.messages=new LinkedList<>();
    }

    public Contact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.messages=new LinkedList<>();
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        String fullName=firstName + " " +lastName;
        if (indexNumber !=0){
            return String.format("-".repeat(100)+
                    "%n%2d. Full Name:%-15s Phone number: %10s%n",indexNumber,fullName,phoneNumber);

        }else {
            return String.format("-".repeat(100)+
                    "%nUnknown Number  Phone number: %10s%n",phoneNumber);
        }

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getPhoneNumber(), contact.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber());
    }
}
