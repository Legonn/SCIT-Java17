package org.example;

import java.util.Random;

public enum TicketType {
    FULL,FULL_VIP,FREE_PASS,ONE_DAY,ONE_DAY_VIP;

    public static TicketType getRandomTicket(){
        Random random=new Random();
        return values()[random.nextInt(values().length)];
    }
}
