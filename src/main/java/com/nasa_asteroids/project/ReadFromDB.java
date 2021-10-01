package com.nasa_asteroids.project;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadFromDB extends ConnectToDB {

    private String resultString;

    public ReadFromDB(String user, String pw, String path) {
        super(user, pw, path);
    }

    public String getResultString() {
        return resultString;
    }
    
    public ResultSet callStoredProcedure(String callStmt, String todaysDate) {
        if (super.checkConnection()) {
            try (
                CallableStatement statement = connection.prepareCall(callStmt);
            ) {
                statement.setString(1, todaysDate);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    String str = "On this day, %s, the closest asteroid to us is %s, traveling ";
                    str += "at %d mph. It missed us by %d miles.";
                    resultString = String.format(str, 
                        rs.getString("DateObserved"), 
                        rs.getString("AsteroidName"), 
                        rs.getInt("MilesPerHour"), 
                        rs.getInt("MilesMissedDistance")
                    ); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}