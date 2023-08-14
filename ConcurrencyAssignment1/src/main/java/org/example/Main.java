package org.example;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();

            for (int i=0;i<100;i++){
                TicketType ticket=TicketType.getRandomTicket();
                FestivalAttendeeThread attendeeThread=new FestivalAttendeeThread(gate,ticket);
                attendeeThread.start();
            }

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();


    }
}