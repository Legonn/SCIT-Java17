package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Phone samsung1=new SamsungGalaxyS22("White","Plastic","1993772611132");

        samsung1.addContact("Alex","Botez","0754257140");
        samsung1.addContact("Andreea"," ","0745412870");
        samsung1.addContact("Maria","Adriana","077517728");

//        printContacts(samsung1);

        samsung1.call("0754257140");
        samsung1.call("0771513004");

//        samsung1.viewHistory();
//        System.out.println(samsung1.findContact("0754257140"));
//        samsung1.getFirstContact();
//        samsung1.getFirstContact();
//        samsung1.getFirstContact();
//        samsung1.getFirstContact();
//        samsung1.getFirstContact();
//        samsung1.getLastContact();
//        samsung1.getLastContact();
//        samsung1.getLastContact();
//        samsung1.getLastContact();
//        samsung1.addContact("Dani","Gurbet","0754772311");
//        samsung1.getLastContact();

        samsung1.sendMessage("0754257140","191823797821983ui1233812y37yahdashdbhjasdbhasdhdasb");
        samsung1.sendMessage("0745412870","Buna ce faci ? eu uite bine  stateam");
        samsung1.getFirstMessage("0754257140");
        samsung1.getLastMessage("0745412870");
        System.out.println(samsung1.getMessage("0754257140",0));
        samsung1.addContact("Alex","Botez","0754257140");
        printContacts(samsung1);
//        samsung1.viewHistory();

        Phone samsung2 = new SamsungGalaxyS22("Gray","plastic","133211311");
        samsung2.call("0754257140");
        samsung2.call("0754257140");
        samsung2.call("0754257140");
        samsung2.call("0754257140");
        samsung2.sendMessage("0754257140","Blabalblababab");
//        samsung2.viewHistory();
        samsung2.call("0754257140");

        samsung1.sendMessage(samsung1.getFirstContact().getPhoneNumber(),"Blabalabala");
        samsung1.getFirstMessage(samsung1.getFirstContact().getPhoneNumber());
        samsung1.getLastMessage(samsung1.getFirstContact().getPhoneNumber());


        Phone iPhone = new Iphone14("White","Plastic","1231312312");
        Phone iPhone1= new Iphone14("Black","Plastic","123131231231");








    }


    private static void printContacts(Phone phone){
        System.out.println(phone.getContacts());
    }

}