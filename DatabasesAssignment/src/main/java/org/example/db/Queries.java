package org.example.db;

public class Queries {



    public static final String url="jdbc:postgresql://localhost/postgres";
    public static final String user="postgres";
    public static final String password="1997";
    public static final String TABLE_ACCOMMODATION ="accommodation";

    public static final String COLUMN_ACCOMMODATION_ID="id";
    public static final String COLUMN_ACCOMMODATION_TYPE="type";
    public static final String COLUMN_ACCOMMODATION_BED_TYPE="bed_type";
    public static final String COLUMN_ACCOMMODATION_MAX_GUESTS="max_guests";
    public static final String COLUMN_ACCOMMODATION_DESCRIPTION="description";
    public static final String CREATE_TABLE_ACCOMMODATION="CREATE TABLE IF NOT EXISTS " + TABLE_ACCOMMODATION
            +" ( " +COLUMN_ACCOMMODATION_ID + " serial PRIMARY KEY ," +COLUMN_ACCOMMODATION_TYPE + " varchar (32), " +
            COLUMN_ACCOMMODATION_BED_TYPE + " varchar(32) ," + COLUMN_ACCOMMODATION_MAX_GUESTS +" int, " +
            COLUMN_ACCOMMODATION_DESCRIPTION + " varchar(512)); ";

    public static final String INSERT_INTO_ACCOMMODATION="INSERT INTO " + TABLE_ACCOMMODATION +
            " ( "+COLUMN_ACCOMMODATION_TYPE + ", " +COLUMN_ACCOMMODATION_BED_TYPE +", " +COLUMN_ACCOMMODATION_MAX_GUESTS +", "
            +COLUMN_ACCOMMODATION_DESCRIPTION +") VALUES (?,?,?,?);";



    public static final String TABLE_ROOM_FAIR="room_fair";
    public static final String COLUMN_ROOM_FAIR_ID="id";
    public static final String COLUMN_ROOM_FAIR_VALUE="value";
    public static final String COLUMN_ROOM_FAIR_SEASON="season";
    public static final String CREATE_TABLE_ROOM_FAIR="CREATE TABLE IF NOT EXISTS " + TABLE_ROOM_FAIR +
            " ( " + COLUMN_ROOM_FAIR_ID + " serial PRIMARY KEY , " +COLUMN_ROOM_FAIR_VALUE + " double precision, " +
            COLUMN_ROOM_FAIR_SEASON + " varchar (32));";

    public static final String INSERT_INTO_ROOM_FAIR="INSERT INTO " + TABLE_ROOM_FAIR +
            " (" +COLUMN_ROOM_FAIR_VALUE +", " + COLUMN_ROOM_FAIR_SEASON +") VALUES (? , ?);";


    public static final String TABLE_ACCOMMODATION_ROOM_FAIR_RELATION="accommodation_room_fair_relation";
    public static final String COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ID="id";
    public static final String COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ACCOMMODATION_ID="accommodation_id";
    public static final String COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ROOM_FAIR_ID="room_fair_id";
    public static final String CREATE_TABLE_ACCOMMODATION_ROOM_FAIR_RELATION ="CREATE TABLE IF NOT EXISTS "
            + TABLE_ACCOMMODATION_ROOM_FAIR_RELATION +
            " ( " + COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ID + " serial PRIMARY KEY , "
            + COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ACCOMMODATION_ID + " int, "
            + COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ROOM_FAIR_ID + " int, " +
            " CONSTRAINT fk_"+TABLE_ACCOMMODATION +" FOREIGN KEY (" +COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ACCOMMODATION_ID +
            ") REFERENCES " +TABLE_ACCOMMODATION+"("+COLUMN_ACCOMMODATION_ID+")," +
            " CONSTRAINT fk_"+TABLE_ROOM_FAIR+" " +
            "FOREIGN KEY ("+COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ROOM_FAIR_ID+")" +
            " REFERENCES " +TABLE_ROOM_FAIR+"("+COLUMN_ROOM_FAIR_ID+"));";

    public static final String INSERT_INTO_ACCOMMODATION_ROOM_FAIR_RELATION="INSERT INTO " +TABLE_ACCOMMODATION_ROOM_FAIR_RELATION +
            "( " +COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ACCOMMODATION_ID +", " +COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ROOM_FAIR_ID +
            ") VALUES (? ,?);";

    public static final String QUERY_ROOM_PRICES="SELECT " +TABLE_ACCOMMODATION+"."+COLUMN_ACCOMMODATION_TYPE +
            ", "+TABLE_ACCOMMODATION+"."+COLUMN_ACCOMMODATION_BED_TYPE +
            ", "+TABLE_ACCOMMODATION+"."+COLUMN_ACCOMMODATION_MAX_GUESTS +
            ", "+TABLE_ACCOMMODATION+"."+COLUMN_ACCOMMODATION_DESCRIPTION +
            ", "+TABLE_ROOM_FAIR+"."+COLUMN_ROOM_FAIR_VALUE +
            " FROM " + TABLE_ROOM_FAIR + " INNER JOIN " +TABLE_ACCOMMODATION_ROOM_FAIR_RELATION +
            " ON " +TABLE_ACCOMMODATION_ROOM_FAIR_RELATION+"."+COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ROOM_FAIR_ID +
            " = " + TABLE_ROOM_FAIR+"." + COLUMN_ROOM_FAIR_ID + " INNER JOIN " + TABLE_ACCOMMODATION +
            " ON " + TABLE_ACCOMMODATION_ROOM_FAIR_RELATION+"."+COLUMN_ACCOMMODATION_ROOM_FAIR_RELATION_ACCOMMODATION_ID+
            " = "+TABLE_ACCOMMODATION+"."+COLUMN_ACCOMMODATION_ID +
            " ORDER BY " +TABLE_ROOM_FAIR+"."+COLUMN_ROOM_FAIR_VALUE;

}
