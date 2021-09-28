package com.nasa_asteroids.project;

public class Asteroid {

    private final String id;
    private final String name;
    private final Double absoluteMagnitude;
    private final Double estimatedDiameterMax;
    private final Double estimatedDiameterMin;
    private final Boolean potentiallyHazardousAsteroid;
    private final String milesPerHour;
    private final String milesMissedDistance;

    private Asteroid(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.absoluteMagnitude = builder.absoluteMagnitude;
        this.estimatedDiameterMax = builder.estimatedDiameterMax;
        this.estimatedDiameterMin = builder.estimatedDiameterMin;
        this.potentiallyHazardousAsteroid = builder.potentiallyHazardousAsteroid;
        this.milesPerHour = builder.milesPerHour;
        this.milesMissedDistance = builder.milesMissedDistance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    public Double getEstimatedDiameterMax() {
        return estimatedDiameterMax;
    }

    public Double getEstimatedDiameterMin() {
        return estimatedDiameterMin;
    }

    public Boolean getPotentiallyHazardousAsteroid() {
        return potentiallyHazardousAsteroid;
    }

    public String getMilesPerHour() {
        return milesPerHour;
    }

    public String getMilesMissedDistance() {
        return milesMissedDistance;
    }

    @Override
    public String toString() {
        return String.format(
            "Asteroid{id=%s, name=%s, absoluteMagnitude=%4.3f, estimatedDiameterMax=%4.3f, estimatedDiameterMin=%4.3f, potentiallyHazardousAsteroid=%b, milesPerHour=%s milesMissedDistance=%s}", 
            id, 
            name, 
            absoluteMagnitude,
            estimatedDiameterMax,
            estimatedDiameterMin,
            potentiallyHazardousAsteroid,
            milesPerHour,
            milesMissedDistance
        );
    }

    public static class Builder {

        private final String id;
        private final String name;
        private Double absoluteMagnitude;
        private Double estimatedDiameterMax;
        private Double estimatedDiameterMin;
        private Boolean potentiallyHazardousAsteroid;
        private String milesPerHour;
        private String milesMissedDistance;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder absoluteMagnitude(Double value) {
            absoluteMagnitude = value;
            return this;
        }

        public Builder estimatedDiameter(Double min, Double max) {
            estimatedDiameterMin = min;
            estimatedDiameterMax = max;
            return this;
        }

        public Builder potentiallyHazardousAsteroid(Boolean value) {
            potentiallyHazardousAsteroid = value;
            return this;
        }

        public Builder milesPerHour(String value) {
            milesPerHour = value;
            return this;
        }

        public Builder milesMissedDistance(String value) {
            milesMissedDistance = value;
            return this;
        }

        public Asteroid build() {
            return new Asteroid(this);
        }
    }
}