package com.jump.cognixia.library.demo3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://192.168.1.127:3306/library";
    private static final String USERNAME = "shoreyo";
    private static final String PASSWORD = "penguinz0";

    private static Connection connection = null;

    private static void makeConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could not make connection to database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            makeConnection();
        }

        return connection;
    }
}
