package org.example.db;

import java.sql.Connection;

public interface ConnectDB {

    boolean open();
    void close();
}
