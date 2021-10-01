USE NasaAsteroids;

DELIMITER $$
CREATE PROCEDURE Get_Closest_Asteroid(IN todays_date DATE)
BEGIN
	SELECT 	
		AsteroidIdNasa,
		AsteroidName,
		ROUND(AbsoluteMagnitude, 2) AS AbsoluteMagnitude,
		ROUND(EstimatedDiameterMin, 2) AS EstimatedDiameterMin,
		ROUND(EstimatedDiameterMax, 2) AS EstimatedDiameterMax,
		PotentiallyHazardousAsteroid,
		ROUND(MilesPerHour, 0) AS MilesPerHour,
		ROUND(MilesMissedDistance, 0) AS MilesMissedDistance,
		DateObserved
	FROM ASTEROIDS
	WHERE DATE(DateObserved) = todays_date
    ORDER BY MilesMissedDistance ASC
    LIMIT 1;
END$$
DELIMITER ;