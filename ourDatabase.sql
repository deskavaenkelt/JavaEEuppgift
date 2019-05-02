SHOW DATABASES;

CREATE DATABASE vaderAktivitet;

USE vaderAktivitet;

CREATE TABLE plats (
    platsId        INT PRIMARY KEY AUTO_INCREMENT,
    platsNamn      VARCHAR(25) NOT NULL,
    platsLongtitud DEC         NOT NULL,
    platsLatitude  DEC         NOT NULL
);

CREATE TABLE aktivitet (
    aktivitetId   INT PRIMARY KEY AUTO_INCREMENT,
    aktivitetNamn VARCHAR(50) NOT NULL
);

CREATE TABLE akivitetsPlats (
    akivitetsPlatsId  INT PRIMARY KEY AUTO_INCREMENT,
    akivitetsPlatsPId INT NOT NULL,
    akivitetsPlatsAId INT NOT NULL,

    FOREIGN KEY (akivitetsPlatsPId) REFERENCES plats (platsId),
    FOREIGN KEY (akivitetsPlatsAId) REFERENCES aktivitet (aktivitetId)
);

CREATE TABLE vader (
    vaderId           INT PRIMARY KEY AUTO_INCREMENT,
    vaderTempMin      INT NOT NULL,
    vaderTempMax      INT NOT NULL,

    vaderNederbordMin INT NOT NULL,
    vaderNederbordMax INT NOT NULL,

    vaderMolnighetMin INT NOT NULL,
    vaderMolnighetMax INT NOT NULL
);


CREATE TABLE aktivitetVader (
    aktivitetVaderId  INT PRIMARY KEY AUTO_INCREMENT,
    aktivitetVaderAId INT NOT NULL,
    aktivitetVaderVId INT NOT NULL,

    FOREIGN KEY (aktivitetVaderAId) REFERENCES aktivitet (aktivitetId),
    FOREIGN KEY (aktivitetVaderVId) REFERENCES vader (vaderId)
);

SHOW TABLES;