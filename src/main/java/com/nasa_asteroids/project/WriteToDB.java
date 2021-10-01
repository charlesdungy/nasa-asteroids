package com.nasa_asteroids.project;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class WriteToDB extends ConnectToDB {

    public WriteToDB(String user, String pw, String path) {
        super(user, pw, path);
    }

    public int[] insert(List<Asteroid> asteroids, String todaysDate, String sqlStmt) {
        int[] updateCounts = null;
        if (super.checkConnection()) {
            try (
                PreparedStatement statement = connection.prepareStatement(sqlStmt);
            ) {
                int index;
                for (Asteroid asteroid : asteroids) {
                    index = 1;
                    statement.setString(index++, asteroid.getId());
                    statement.setString(index++, asteroid.getName());
                    statement.setDouble(index++, asteroid.getAbsoluteMagnitude());
                    statement.setDouble(index++, asteroid.getEstimatedDiameterMin());
                    statement.setDouble(index++, asteroid.getEstimatedDiameterMax());
                    statement.setBoolean(index++, asteroid.getPotentiallyHazardousAsteroid());
                    statement.setString(index++, asteroid.getMilesPerHour());
                    statement.setString(index++, asteroid.getMilesMissedDistance());
                    statement.setString(index++, todaysDate);
                    statement.addBatch();
                }
                updateCounts = statement.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateCounts;
    }
}