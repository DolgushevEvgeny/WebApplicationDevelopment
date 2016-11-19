package com.eugenedolgushev.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public final class DBConnection {

    private static Connection connection;
    private static Logger log = Logger.getLogger(DBConnection.class.getName());

    private DBConnection() {
    }

    public static Connection getConnection() throws IOException {
        Handler handler = new FileHandler("C:\\Windows\\Temp\\app.log");
        Logger.getLogger("").addHandler(handler);
        if (connection != null) {
            return connection;
        }
        try {
            final String url = "jdbc:mysql://localhost:3306/lab2.db";
            final String user = "root";
            final String password = "svenSPS678";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            log.severe(e.getMessage());
        } catch(ClassNotFoundException e) {
            log.severe(e.getMessage());
        }

        return connection;
    }

    public static void closeConnection(final Connection toClose) {
        if (toClose == null) {
            return;
        }
        try {
            toClose.close();
        } catch(SQLException e) {
            log.severe(e.getMessage());
        }
    }
}
