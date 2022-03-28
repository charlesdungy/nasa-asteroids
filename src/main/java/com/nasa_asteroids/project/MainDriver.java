package com.nasa_asteroids.project;

import java.io.File;
import java.util.List;

public class MainDriver {

    public static void main(String args[]) {
        String configFilePath = getConfigFilePath();
        Config config = getConfig(configFilePath);

        // Get response, parse it, and set Asteroid objects.
        String dateFormat = "uuuu-MM-dd";
        String response = new CreateRequest(
            getURI(
                getTodaysDate(dateFormat), 
                config.getAPIKey())
            ).getResponse();
        ProcessResponse pr = new ProcessResponse(response, getTodaysDate(dateFormat));
        List<Asteroid> asteroids = getAsteroids(pr);

        // Inserting and Reading to/from db.
        String totalInserted = insertIntoDB(config, asteroids);
        System.out.println(totalInserted);
        String resultString = readFromDB(config);

        // Sending Tweet.
        String hashtagFilePath = config.getHashtagFile();
        String randomHashtag = getRandomHashtag(hashtagFilePath);
        BuildTwitterInstance twitter = getTwitterInstance(config);
        twitter.buildConfiguration();
        twitter.postTweet(String.join(" ", resultString, randomHashtag));
    }

    public static BuildTwitterInstance getTwitterInstance(Config config) {
        return new BuildTwitterInstance(
            config.getTwitterAPIKey(),
            config.getTwitterAPIKeySecret(),
            config.getTwitterAccessToken(),
            config.getTwitterAccessTokenSecret()
        );
    }

    public static String getConfigFilePath() {
        return "/Users/charlesdungy/GitHub/nasa-asteroids/project/src/main/resources/config.txt";
    }

    public static String readFromDB(Config config) {
        String sqlStmt = "{ CALL Get_Closest_Asteroid(?) }";
        ReadFromDB dbRead = new ReadFromDB(
            config.getDbUser(), 
            config.getDbPassword(), 
            config.getDbPath()
        );
        
        String dateFormat = "uuuu-MM-dd";
        String resultDateFormat = "MM-dd-uuuu";
        
        dbRead.createConnection();
        dbRead.callStoredProcedure(
            sqlStmt, 
            getTodaysDate(dateFormat), 
            getTodaysDate(resultDateFormat)
        );
        dbRead.closeConnection();
        return dbRead.getResultString();
    }

    public static String insertIntoDB(Config config, List<Asteroid> asteroids) {
        String sqlStmt = getInsertSQLStmt(); 
        WriteToDB writeToDB = new WriteToDB(
            config.getDbUser(), 
            config.getDbPassword(), 
            config.getDbPath()
        );
        
        writeToDB.createConnection();
        String dateFormat = "uuuu-MM-dd";
        int[] updateCounts = writeToDB.insert(asteroids, getTodaysDate(dateFormat), sqlStmt);
        writeToDB.closeConnection();
        return String.format("Total inserted: %d", updateCounts.length);
    }

    public static String getInsertSQLStmt() {
        String sqlStmt = "INSERT INTO ASTEROIDS (AsteroidIdNasa, AsteroidName, ";
        sqlStmt += "AbsoluteMagnitude, EstimatedDiameterMin, EstimatedDiameterMax, ";
        sqlStmt += "PotentiallyHazardousAsteroid, MilesPerHour, ";
        sqlStmt += "MilesMissedDistance, DateObserved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return sqlStmt;    
    }

    public static List<Asteroid> getAsteroids(ProcessResponse pr) {
        pr.parseResponse();
        pr.buildAsteroid();
        return pr.getAsteroids();
    }

    public static String getRandomHashtag(String filename) {
        RandomHashtag randomHashtag = new RandomHashtag(filename);
        return randomHashtag.getFinalHashtag();
    }

    public static Config getConfig(String filename) {
        return new Config(new File(filename));
    }

    public static String getTodaysDate(String format) {
        return new TodaysDate(format).getTodaysDate();
    }

    public static String getURI(String todaysDate, String APIKey) {
        BuildURI createURI = new BuildURI(todaysDate, APIKey);
        return createURI.getURI();
    }
}