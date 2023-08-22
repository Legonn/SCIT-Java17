package org.example.db;

import org.example.model.AccommodationByPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.db.Queries.*;

public class PostgreSQLDB implements ConnectDB {

    private Connection connection;
    private PreparedStatement createAccommodationTableQuery;
    private PreparedStatement createRoomFairTableQuery;
    private PreparedStatement createAccommodationRoomFairRelationTableQuery;
    private PreparedStatement insertIntoAccommodation;
    private PreparedStatement insertIntoRoom_Fair;
    private PreparedStatement insertIntoAccommodation_Room_Fair_Relation;
    private PreparedStatement queryRoomPrices;

    @Override
    public boolean open() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.setLoginTimeout(60);
            connection = DriverManager.getConnection(url, user, password);

            createAccommodationTableQuery = connection.prepareStatement(CREATE_TABLE_ACCOMMODATION);
            createRoomFairTableQuery = connection.prepareStatement(CREATE_TABLE_ROOM_FAIR);
            createAccommodationRoomFairRelationTableQuery = connection.prepareStatement(CREATE_TABLE_ACCOMMODATION_ROOM_FAIR_RELATION);
            queryRoomPrices = connection.prepareStatement(QUERY_ROOM_PRICES);

            createAccommodationTableQuery.execute();
            createRoomFairTableQuery.execute();
            createAccommodationRoomFairRelationTableQuery.execute();
            insertIntoAccommodation = connection.prepareStatement(INSERT_INTO_ACCOMMODATION);
            insertIntoRoom_Fair = connection.prepareStatement(INSERT_INTO_ROOM_FAIR);
            insertIntoAccommodation_Room_Fair_Relation = connection.prepareStatement(INSERT_INTO_ACCOMMODATION_ROOM_FAIR_RELATION);

            System.out.println("Connected to the PostgresSQL server Successfully");
            return true;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Couldn't connect to DB " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void close() {
        try {
            if (createAccommodationTableQuery != null) {
                createAccommodationTableQuery.close();
            }
            if (insertIntoAccommodation != null) {
                insertIntoAccommodation.close();
            }
            if (insertIntoRoom_Fair != null) {
                insertIntoRoom_Fair.close();
            }
            if (insertIntoAccommodation_Room_Fair_Relation != null) {
                insertIntoAccommodation_Room_Fair_Relation.close();
            }
            if (queryRoomPrices != null){
                queryRoomPrices.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int insertIntoAccommodationQuery(String type, String bed_type, int max_guests, String description) {
        int result = -1;
        try {
            connection.setAutoCommit(false);
            insertIntoAccommodation.setString(1, type);
            insertIntoAccommodation.setString(2, bed_type);
            insertIntoAccommodation.setInt(3, max_guests);
            insertIntoAccommodation.setString(4, description);
            int affectedRows = insertIntoAccommodation.executeUpdate();
            if (affectedRows == 1) {
                connection.commit();
                result = affectedRows;
            } else {
                throw new SQLException("Couldn't insert the record ");
            }
        } catch (SQLException e) {
            System.out.println("Insert record Exception " + e.getMessage());
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Big issue, couldn't roll back " + ex);
                ex.printStackTrace();
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior ");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset autocommit " + e.getMessage());
            }
        }
        return result;
    }

    public int insertIntoRoomFairQuery(double value, String season) {
        int result = -1;
        try {
            connection.setAutoCommit(false);
            insertIntoRoom_Fair.setDouble(1, value);
            insertIntoRoom_Fair.setString(2, season);
            int affectedRows = insertIntoRoom_Fair.executeUpdate();
            if (affectedRows == 1) {
                connection.commit();
                result = affectedRows;
            } else {
                throw new SQLException("Couldn't insert the record ");
            }
        } catch (SQLException e) {
            System.out.println("Insert record Exception " + e.getMessage());
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Big issue, couldn't roll back " + ex);
                ex.printStackTrace();
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior ");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset autocommit " + e.getMessage());
            }
        }
        return result;
    }

    public void insertIntoAccommodationRoomFairRelationQuery(int accommodationID, int roomFairID) {
        try {
            connection.setAutoCommit(false);
            insertIntoAccommodation_Room_Fair_Relation.setInt(1, accommodationID);
            insertIntoAccommodation_Room_Fair_Relation.setInt(2, roomFairID);
            int affectedRows = insertIntoAccommodation_Room_Fair_Relation.executeUpdate();
            if (affectedRows == 1) {
                connection.commit();
            } else {
                throw new SQLException("Couldn't insert the record ");
            }
        } catch (SQLException e) {
            System.out.println("Insert record Exception " + e.getMessage());
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Big issue, couldn't roll back " + ex);
                ex.printStackTrace();
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior ");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset autocommit " + e.getMessage());
            }
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT (*) AS count FROM " + table;
        int count = -1;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                count = resultSet.getInt("count");
                System.out.format("Count = %d \n", count);
                return count;
            }
        } catch (SQLException e) {
            System.out.println("QUERY failed " + e.getMessage());
        }
        return count;
    }

    public List<AccommodationByPrice> getListOfRoomsOrderedByPrice() {
        List<AccommodationByPrice> list=new ArrayList<>();
        try(ResultSet resultSet=queryRoomPrices.executeQuery()){
            while (resultSet.next()){
                AccommodationByPrice accommodationByPrice=new AccommodationByPrice();
                accommodationByPrice.setType(resultSet.getString(1));
                accommodationByPrice.setBed_type(resultSet.getString(2));
                accommodationByPrice.setMax_guests(resultSet.getInt(3));
                accommodationByPrice.setDescription(resultSet.getString(4));
                accommodationByPrice.setPrice(resultSet.getDouble(5));
                list.add(accommodationByPrice);
            }
            return list;

        }catch (SQLException e){
            System.out.println("Couldn't perform the query");
            return null;
        }
    }


}
