package com.nasa_asteroids.project;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.jayway.jsonpath.JsonPath;
import com.nasa_asteroids.project.Asteroid.Builder;

public class ProcessResponse {
    
    private List<Asteroid> asteroids = new ArrayList<Asteroid>();
    private final String response;
    private final int elementCount;
    private final String todaysDate;
    private List<String> ids; 
    private List<String> names;
    private List<Double> absoluteMagitude;
    private List<Double> minDiameter;
    private List<Double> maxDiameter;
    private List<Boolean> hazaradousAsteroid;
    private List<String> milesPerHour;
    private List<String> milesMissDistance; 

    private List<String> elementsToParse = Arrays.asList(
        "id", 
        "name", 
        "absolute_magnitude_h", 
        "estimated_diameter.meters.estimated_diameter_min",
        "estimated_diameter.meters.estimated_diameter_max", 
        "is_potentially_hazardous_asteroid",
        "close_approach_data.[*].relative_velocity.miles_per_hour",
        "close_approach_data.[*].miss_distance.miles"
    );

    public ProcessResponse(String response, String todaysDate) {
        this.response = response;
        this.todaysDate = todaysDate;
        this.elementCount = findElementCount(response);
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public void buildAsteroid() {
        for (int i = 0; i < elementCount; i++) {
            Builder asteroidBuilder = new Asteroid.Builder(ids.get(i), names.get(i));
            
            asteroidBuilder.absoluteMagnitude(absoluteMagitude.get(i))
                .estimatedDiameter(minDiameter.get(i), maxDiameter.get(i))
                .potentiallyHazardousAsteroid(hazaradousAsteroid.get(i))
                .milesPerHour(milesPerHour.get(i))
                .milesMissedDistance(milesMissDistance.get(i));

            asteroids.add(asteroidBuilder.build());
        }
    }

    public void parseResponse() {
        if (elementCount > 0) {
            for (int i = 0; i < elementsToParse.size(); ) {
                ids = getElements(elementsToParse.get(i++)); 
                names = getElements(elementsToParse.get(i++));
                absoluteMagitude = getElements(elementsToParse.get(i++));
                minDiameter = getElements(elementsToParse.get(i++));
                maxDiameter = getElements(elementsToParse.get(i++));
                hazaradousAsteroid = getElements(elementsToParse.get(i++));
                milesPerHour = getElements(elementsToParse.get(i++));
                milesMissDistance = getElements(elementsToParse.get(i++)); 
            }
        }
    }

    private <T> List<T> getElements(String element) {
        String jsonPath = String.format("$.near_earth_objects.%s.[*].%s", todaysDate, element);
        return JsonPath.parse(response).read(jsonPath);
    }

    private int findElementCount(String response) {
        String jsonPath = "$.element_count";
        return JsonPath.parse(response).read(jsonPath);
    }
}