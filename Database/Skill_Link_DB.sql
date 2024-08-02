DROP DATABASE IF EXISTS skillLink;
CREATE DATABASE skillLink;
USE skillLink;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS ServiceProviders;

CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    NameFirst VARCHAR(50),
    NameLast VARCHAR(50),
    Username VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(20),
    Address VARCHAR(100)
);

CREATE TABLE ServiceProviders (
    ServiceProviderID INT PRIMARY KEY AUTO_INCREMENT,
    NameFirst VARCHAR(50),
    NameLast VARCHAR(50),
    Username VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(20),
	Skills Varchar(30),
    Wages VARCHAR(50),
    Address VARCHAR(100)
);

desc Users;
desc ServiceProviders;
