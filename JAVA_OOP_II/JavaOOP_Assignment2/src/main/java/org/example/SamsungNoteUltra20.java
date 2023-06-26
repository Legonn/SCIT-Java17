package org.example;

import java.util.*;

public class SamsungNoteUltra20 extends Samsung{

    private final String imei;
    private LinkedHashSet<Contact> contacts;

    private LinkedList<Contact> callList;

    public SamsungNoteUltra20(String color, String material, String imei) {
        super(color, material, 2000);
        this.imei = imei;
        this.contacts=new LinkedHashSet<>(200);
        this.callList=new LinkedList<>();
    }



    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        if (batteryLife>0){
            Contact contact =new Contact(firstName,lastName,phoneNumber);
            int newIndexNumber=contacts.size()+1;
            contact.setIndexNumber(newIndexNumber);
            if (firstName==null){
                firstName="";
            } else if (lastName==null) {
                lastName="";
            }
            contacts.add(contact);
        }else {
            System.out.println("Recharge");
        }


    }
    public HashSet<Contact> getContacts() {
        return contacts;
    }



    @Override
    public Contact getFirstContact() {
        if (batteryLife>0){
            Iterator<Contact> iterator=contacts.iterator();
            if (iterator.hasNext()){
                Contact returnedContact=iterator.next();
                return returnedContact;
            }else {
                System.out.println("Your contact list is empty");
            }
        }else {
            System.out.println("Recharge");
        }

        return null;
    }

    @Override
    public Contact getLastContact() {
        if (batteryLife>0){
            Iterator<Contact> iterator=contacts.iterator();
            Contact lastContact = null;

            while (iterator.hasNext()){
                lastContact=iterator.next();
            }
            if (lastContact !=null){
                return lastContact;
            }else {
                System.out.println("Your contact list is empty");
            }
        }else {
            System.out.println("Recharge");
        }
        return null;

    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (batteryLife>0){
            Contact unknownContact=new Contact(phoneNumber);
            if (findContact(phoneNumber) !=null){
                findContact(phoneNumber).messages.add(new Message(messageContent));
            }else{
                unknownContact.messages.add(new Message(messageContent));
            }

            batteryLife --;
        }else {
            System.out.println("Recharge");
        }


    }

    @Override
    public Message getMessage(String phoneNumber,int messageIndex) {
        if (batteryLife>0){
            Contact contact = findContact(phoneNumber);

            if (contact != null) {
                LinkedList<Message> messages = contact.getMessages();

                if (messageIndex >= 0 && messageIndex < messages.size()) {
                    return messages.get(messageIndex);
                }
            }

            return null;
        }else {
            System.out.println("Recharge");
            return null;
        }

    }

    @Override
    public Message getLastMessage(String phoneNumber) {
        if (batteryLife>0){
            System.out.println(getMessage(phoneNumber,findContact(phoneNumber).messages.size()-1));
            return getMessage(phoneNumber,findContact(phoneNumber).messages.size()-1);
        }else {
            System.out.println("Recharge");
            return null;
        }

    }

    @Override
    public Message getFirstMessage(String phoneNumber) {
        if (batteryLife>0){
            System.out.println(getMessage(phoneNumber,0));
            return getMessage(phoneNumber,0);
        }else {
            System.out.println("Recharge");
            return null;
        }

    }

    @Override
    public void call(String phoneNumber) {
        if (batteryLife>=2){
            Contact unknownContact = new Contact(phoneNumber);
            if (findContact(phoneNumber) !=null){
                callList.add(findContact(phoneNumber));
            }else {
                callList.add(unknownContact);
            }
            batteryLife -=2;
        }else {
            System.out.println("Recharge");
        }



    }

    @Override
    public void viewHistory() {
        if (batteryLife>0){
            ListIterator<Contact> iterator =callList.listIterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS22{" +
                "imei='" + imei + '\'' +
                ", contacts=" + contacts +
                ", callList=" + callList +
                ", batteryLife=" + batteryLife +
                "} " + super.toString();
    }



    public Contact findContact(String phoneNumber){
        if (batteryLife>0){
            for (var contact:contacts){
                if (contact.getPhoneNumber().equals(phoneNumber)){
                    return contact;
                }
            }
            return null;
        }else {
            return null;
        }

    }
}
