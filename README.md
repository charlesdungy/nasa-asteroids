# NASA Asteroids

This is a Java project that uses the [Nasa Asteroid - NeoWs (Near Earth Object Web Service) API](https://api.nasa.gov) to tweet details about the nearest object to Earth.

## Description

The program gets data from the Nasa Asteroid - NeoWs API on a daily basis, per the given date. After processing the response into Asteroid objects, the data are stored in a MySQL database. 

The closest object to Earth ~~is~~ was found among the data based on ~~today's~~ some day's date and that information ~~is~~ was then tweeted [@closestAsteroid](https://twitter.com/closestAsteroid).

Note: this program is no longer running.

Here is a high level look at the program.

![programFlow](https://github.com/charlesdungy/nasa-asteroids/blob/main/images/programFlow.png?raw=true)

## License
MIT