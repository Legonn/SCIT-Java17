package org.example;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {

    private Queue<TicketType> ticketQueue=new ConcurrentLinkedQueue<>();


    public void validateTicket(TicketType ticketType){
        ticketQueue.add(ticketType);
    }

    public Queue<TicketType> getTicketQueue() {
        return ticketQueue;
    }

}
