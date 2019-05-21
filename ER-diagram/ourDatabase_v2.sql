SHOW DATABASES;



-- Create databases
CREATE DATABASE weatherActivityApi;
USE weatherActivityApi;



-- Create tables
CREATE TABLE place (
    placeId        INT PRIMARY KEY AUTO_INCREMENT,
    placeName      VARCHAR(25) NOT NULL,
    placeLongitude VARCHAR(20) NOT NULL,
    placeLatitude  VARCHAR(20) NOT NULL
);

CREATE TABLE activity (
    activityId   INT PRIMARY KEY AUTO_INCREMENT,
    activityName VARCHAR(50) NOT NULL
);

CREATE TABLE activityPlace (
    activityPlaceId  INT PRIMARY KEY AUTO_INCREMENT,
    activityPlacePId INT NOT NULL,
    activityPlaceAId INT NOT NULL,

    FOREIGN KEY (activityPlaceId) REFERENCES place (placeId),
    FOREIGN KEY (activityPlaceId) REFERENCES activity (activityId)
);

CREATE TABLE weather (
    weatherId           INT PRIMARY KEY AUTO_INCREMENT,
    weatherTemperature  INT NOT NULL,

    weatherRainfall     INT NOT NULL,

    weatherCloudy       INT NOT NULL
);

CREATE TABLE activityWeather (
    activityWeatherId  INT PRIMARY KEY AUTO_INCREMENT,
    activityWeatherAId INT NOT NULL,
    activityWeatherVId INT NOT NULL,

    FOREIGN KEY (activityWeatherAId) REFERENCES activity (activityId),
    FOREIGN KEY (activityWeatherVId) REFERENCES weather (weatherId)
);



-- Fill the tables with data
SHOW TABLES;

-- Insert the koordinates for the places
INSERT INTO place(placeName, placeLongitude, placeLatitude)
VALUES ('Göteborg', '11.85', '57.66'),
       ('Kungsbacka', '11.96', '57.49'),
       ('Åsa', '12.07', '57.33'),
       ('Varberg', '12.25', '57.10'),
       ('Falkenberg', '12.50', '56.88');


DESCRIBE place;

SELECT *
FROM place;

