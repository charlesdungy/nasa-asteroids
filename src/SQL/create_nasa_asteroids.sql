CREATE DATABASE NasaAsteroids;
USE NasaAsteroids;

CREATE TABLE ASTEROIDS (
    AsteroidIdNasa VARCHAR(20),
    AsteroidName TEXT,
    AbsoluteMagnitude DOUBLE,
    EstimatedDiameterMin DOUBLE,
    EstimatedDiameterMax DOUBLE,
    PotentiallyHazardousAsteroid TEXT,
    MilesPerHour TEXT,
    MilesMissedDistance TEXT,
    DateObserved DATE,
    PRIMARY KEY (AsteroidIdNasa, DateObserved)
);