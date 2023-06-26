package org.example;

import java.util.HashSet;

public interface Phone {
    public void addContact(String firstName, String lastName, String phoneNumber);
//    public void addContact2(int contactNumber,String phoneNumber,String firstName,String lastName);

    public Contact getFirstContact();
    public Contact getLastContact();

    public void sendMessage(String phoneNumber,String messageContent);

    public Message getMessage(String phoneNumber,int messageIndex);
    public Message getLastMessage(String phoneNumber);
    public Message getFirstMessage(String phoneNumber);



    public void call(String phoneNumber);

    public void viewHistory();

    default HashSet<Contact> getContacts(){
        return getContacts();
    }
    Contact findContact(String phoneNumber);


}
