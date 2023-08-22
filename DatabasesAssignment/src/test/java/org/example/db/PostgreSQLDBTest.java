package org.example.db;

import org.example.model.AccommodationByPrice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PostgreSQLDBTest {
    private PostgreSQLDB postgreSQLDB;
    private int accommodationID;
    private int roomFairId;
    private int expectedResult;
    @Before
    public void setUp() throws Exception {
        postgreSQLDB = new PostgreSQLDB();
        if (!postgreSQLDB.open()) {
            System.out.println("Couldn't connect to db ");
            return;
        }
        accommodationID=postgreSQLDB.insertIntoAccommodationQuery("dada", "large", 3, "nice");
        roomFairId=postgreSQLDB.insertIntoRoomFairQuery(5.34,"summer");
        expectedResult= postgreSQLDB.getCount(Queries.TABLE_ACCOMMODATION_ROOM_FAIR_RELATION) +1;
    }


    @Test
    public void testIfInsertIntoAccommodationRoomFairRelationMethod_InsertsOneRecord() {
        postgreSQLDB.insertIntoAccommodationRoomFairRelationQuery(
                accommodationID, roomFairId);
        assertEquals(expectedResult,postgreSQLDB.getCount(Queries.TABLE_ACCOMMODATION_ROOM_FAIR_RELATION));

    }

    @Test
    public void testIfGetListOfRoomsOrderedByPriceMethod_ReturnsAListOfAccommodationByPriceObjects(){
        List<AccommodationByPrice> list=postgreSQLDB.getListOfRoomsOrderedByPrice();
        list.forEach(System.out::println);
        assertTrue(list.size()>0);
    }
    @After
    public void tearDown() throws Exception {
        postgreSQLDB.close();
    }

}