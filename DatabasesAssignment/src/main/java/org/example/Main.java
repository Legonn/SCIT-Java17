package org.example;

import org.example.db.PostgreSQLDB;
import org.example.db.Queries;

import java.sql.Connection;
import java.sql.SQLException;
import static org.example.db.Queries.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        PostgreSQLDB postgreSQLDB=new PostgreSQLDB();

        if (!postgreSQLDB.open()){
            System.out.println("Can't Open Data Source");
            return;
        }
//       int accommodationID= postgreSQLDB.insertIntoAccommodationQuery("tata","king",5,"Beautiful");
//        System.out.println(accommodationID);
//
//        int roomFairId=postgreSQLDB.insertIntoRoomFairQuery(3.4535,"Summer");
//        System.out.println(roomFairId);
//        postgreSQLDB.insertIntoAccommodationRoomFairRelationQuery(accommodationID,roomFairId);

        postgreSQLDB.getListOfRoomsOrderedByPrice().forEach(System.out::println);
        
        postgreSQLDB.close();

    }
}