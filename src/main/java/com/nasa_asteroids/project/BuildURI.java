package com.nasa_asteroids.project;

public class BuildURI {
    
    private String URI;

    public BuildURI(String todaysDate, String apiKey) {
        this.URI = createURI(todaysDate, apiKey);
    }

    public String getURI() {
        return URI;
    }

    private String createURI(String todaysDate, String apiKey) {
        return String.format(
            "https://api.nasa.gov/neo/rest/v1/feed?start_date=%s&end_date=%s&api_key=%s",
            todaysDate,
            todaysDate,
            apiKey
        );
    }
}