package com.nasa_asteroids.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

    private final String username;
    private final String password;
    private final String connectionPath;
    protected Connection connection;
    
    public ConnectToDB(String user, String pw, String path) {
        this.username = user;
        this.password = pw;
        this.connectionPath = path;
    }

    public void createConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                connectionPath, 
                username, 
                password
            );
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkConnection() {
        int timeout = 30;
        try {
            return connection.isValid(timeout);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void closeConnection() {
        if (checkConnection()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}