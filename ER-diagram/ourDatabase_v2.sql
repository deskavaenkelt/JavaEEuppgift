SHOW DATABASES;


-- Create databases
CREATE DATABASE weatherActivityApi;
USE weatherActivityApi;



-- Create tables
CREATE TABLE place (
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(25) NOT NULL,
    longitude VARCHAR(20) NOT NULL,
    latitude  VARCHAR(20) NOT NULL
);

CREATE TABLE activity (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE activityPlace (
    id  INT PRIMARY KEY AUTO_INCREMENT,
    pId INT NOT NULL,
    aId INT NOT NULL,

    FOREIGN KEY (pId) REFERENCES place (id),
    FOREIGN KEY (aId) REFERENCES activity (id)
);

CREATE TABLE weatherOptimal (
    id           INT PRIMARY KEY AUTO_INCREMENT,

    cloudy       INT NOT NULL,
    rainfall     INT NOT NULL,
    temperature  INT NOT NULL,
    wind         INT NOT NULL
);

CREATE TABLE activityWeather (
    id  INT PRIMARY KEY AUTO_INCREMENT,
    aId INT NOT NULL,
    vId INT NOT NULL,

    FOREIGN KEY (aId) REFERENCES activity (id),
    FOREIGN KEY (vId) REFERENCES weatherOptimal (id)
);



-- Fill the tables with data
SHOW TABLES;

-- Insert the koordinates for the places
INSERT INTO place(name, longitude, latitude)
VALUES ('Göteborg', '11.85', '57.66'),
       ('Kungsbacka', '11.96', '57.49'),
       ('Åsa', '12.07', '57.33'),
       ('Varberg', '12.25', '57.10'),
       ('Falkenberg', '12.50', '56.88');


DESCRIBE place;

SELECT *
FROM place;



-- Skapa cache tabeller, fyll på med startvärden som sedan uppdateras via JavaEE
CREATE TABLE cachePlaceParameters (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    place       INT NOT NULL,
    day         INT NOT NULL,

    temperature INT NOT NULL,
    wind        INT NOT NULL,
    cloud       INT NOT NULL,

    FOREIGN KEY (place) REFERENCES place (id)
);

INSERT INTO cachePlaceParameters(place, day, temperature, wind, cloud)
VALUES (1, 0, 0, 0, 0),
       (1, 1, 0, 0, 0),
       (1, 2, 0, 0, 0),
       (1, 3, 0, 0, 0),
       (1, 4, 0, 0, 0),
       (1, 5, 0, 0, 0),
       (2, 0, 0, 0, 0),
       (2, 1, 0, 0, 0),
       (2, 2, 0, 0, 0),
       (2, 3, 0, 0, 0),
       (2, 4, 0, 0, 0),
       (2, 5, 0, 0, 0),
       (3, 0, 0, 0, 0),
       (3, 1, 0, 0, 0),
       (3, 2, 0, 0, 0),
       (3, 3, 0, 0, 0),
       (3, 4, 0, 0, 0),
       (3, 5, 0, 0, 0),
       (4, 0, 0, 0, 0),
       (4, 1, 0, 0, 0),
       (4, 2, 0, 0, 0),
       (4, 3, 0, 0, 0),
       (4, 4, 0, 0, 0),
       (4, 5, 0, 0, 0),
       (5, 0, 0, 0, 0),
       (5, 1, 0, 0, 0),
       (5, 2, 0, 0, 0),
       (5, 3, 0, 0, 0),
       (5, 4, 0, 0, 0),
       (5, 5, 0, 0, 0);



CREATE TABLE cacheScores (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    place          INT NOT NULL,
    day            INT NOT NULL,

    fishing        INT NOT NULL,
    outdoorSeating INT NOT NULL,
    sunBathing     INT NOT NULL,
    volleyBall     INT NOT NULL,
    windSurfing    INT NOT NULL,

    FOREIGN KEY (place) REFERENCES place (id)
);

INSERT INTO cacheScores(place, day, fishing, outdoorSeating, sunBathing, volleyBall, windSurfing)
VALUES (1, 0, 0, 0, 0, 0, 0),
       (1, 1, 0, 0, 0, 0, 0),
       (1, 2, 0, 0, 0, 0, 0),
       (1, 3, 0, 0, 0, 0, 0),
       (1, 4, 0, 0, 0, 0, 0),
       (1, 5, 0, 0, 0, 0, 0),
       (2, 0, 0, 0, 0, 0, 0),
       (2, 1, 0, 0, 0, 0, 0),
       (2, 2, 0, 0, 0, 0, 0),
       (2, 3, 0, 0, 0, 0, 0),
       (2, 4, 0, 0, 0, 0, 0),
       (2, 5, 0, 0, 0, 0, 0),
       (3, 0, 0, 0, 0, 0, 0),
       (3, 1, 0, 0, 0, 0, 0),
       (3, 2, 0, 0, 0, 0, 0),
       (3, 3, 0, 0, 0, 0, 0),
       (3, 4, 0, 0, 0, 0, 0),
       (3, 5, 0, 0, 0, 0, 0),
       (4, 0, 0, 0, 0, 0, 0),
       (4, 1, 0, 0, 0, 0, 0),
       (4, 2, 0, 0, 0, 0, 0),
       (4, 3, 0, 0, 0, 0, 0),
       (4, 4, 0, 0, 0, 0, 0),
       (4, 5, 0, 0, 0, 0, 0),
       (5, 0, 0, 0, 0, 0, 0),
       (5, 1, 0, 0, 0, 0, 0),
       (5, 2, 0, 0, 0, 0, 0),
       (5, 3, 0, 0, 0, 0, 0),
       (5, 4, 0, 0, 0, 0, 0),
       (5, 5, 0, 0, 0, 0, 0);

SELECT @@global.time_zone, @@session.time_zone;

SET GLOBAL time_zone = '+01:00';
SET SESSION time_zone = '+01:00';
