package org.example;

import java.util.HashMap;
import java.util.Map;

public class FestivalStatisticsThread extends Thread{

    private final FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }


    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(5000);
                int counter=0;
                Map<TicketType,Integer> statistics=new HashMap<>();
                if (gate.getTicketQueue().isEmpty()){
                    break;
                }else {
                    for (TicketType ticketType:gate.getTicketQueue()){
                      statistics.put(ticketType, statistics.getOrDefault(ticketType,0)+1);
                      gate.getTicketQueue().remove(ticketType);
                    }
                }
                for (Integer value:statistics.values()){
                    counter +=value;
                }
                System.out.println("Festival Statistics: ");
                System.out.println(counter +" people entered");
                for (TicketType ticketType:statistics.keySet()){
                    System.out.printf("%d have  %s ticket(s)%n",statistics.get(ticketType),ticketType);
                }
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

