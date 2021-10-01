package com.nasa_asteroids.project;

public class BuildURI {
    
    private String URI;

    public BuildURI(String todaysDate, String apiKey) {
        createURI(todaysDate, apiKey);
    }

    public String getURI() {
        return URI;
    }

    private void createURI(String todaysDate, String apiKey) {
        this.URI = String.format(
            "https://api.nasa.gov/neo/rest/v1/feed?start_date=%s&end_date=%s&api_key=%s",
            todaysDate,
            todaysDate,
            apiKey
        );
    }
}