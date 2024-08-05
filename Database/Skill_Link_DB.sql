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

CREATE TABLE UserRequirements (
	RequirementID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    Skills VARCHAR(100),
    Wages VARCHAR(50),
    Address VARCHAR(100),
    Date DATE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE Feedback (
	Username VARCHAR(50),
    ServiceProviderUsername VARCHAR(50) NOT NULL,
    FeedbackMessage TEXT NOT NULL,
    Rating INT NOT NULL,
	FOREIGN KEY (ServiceProviderUsername) REFERENCES ServiceProviders(Username)
);


CREATE TABLE BookingList (
	RequirementID INT,
    UserID INT,
   -- ServiceProviderID INT,--
	Username VARCHAR(50) NOT NULL,
    NameFirst VARCHAR(50),
    NameLast VARCHAR(50),
    PhoneNumber VARCHAR(10),
	Skills VARCHAR(50),
    Wages VARCHAR(50),
    -- FOREIGN KEY (ServiceProviderID) REFERENCES ServiceProviders(ServiceProviderID),--
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
	FOREIGN KEY (Username) REFERENCES ServiceProviders(Username)
);

CREATE TABLE Status (
    -- UserID INT,
	RequirementID INT,
	ServiceProviderUserName VARCHAR(50) NOT NULL UNIQUE,
	IsSelected BOOLEAN,
	FOREIGN KEY (ServiceProviderUsername) REFERENCES ServiceProviders(Username)
);

