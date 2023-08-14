package org.example;

import java.util.Random;

public class FestivalAttendeeThread extends Thread{

    private FestivalGate gate;
    private TicketType ticketType;

    public FestivalAttendeeThread(FestivalGate gate,TicketType ticketType) {
        this.gate = gate;
        this.ticketType =ticketType;
    }

    public FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
        this.ticketType =TicketType.getRandomTicket();
    }


    @Override
    public void run() {
        synchronized (gate){
            try{
                gate.validateTicket(ticketType);
                System.out.println("one " +ticketType +" has been validated ");
                Thread.sleep(new Random().nextInt(50,250));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
