CREATE DATABASE Tacompanion;


CREATE TABLE Picture(
picId INT PRIMARY KEY AUTO_INCREMENT,
picName VARCHAR(25),
path VARCHAR(30));

CREATE TABLE Preferences(
prefId INT PRIMARY KEY AUTO_INCREMENT,
descrip VARCHAR(200)
);

CREATE TABLE Users(
username VARCHAR(20) PRIMARY KEY,
firstName VARCHAR(15),
lastName VARCHAR(25),
passwrd VARCHAR(20) NOT NULL,
picId INT,
FOREIGN KEY(picId) REFERENCES Picture(picId)
);

CREATE TABLE UsersPrefs(
username VARCHAR(20),
prefId INT,
PRIMARY KEY(username,prefId),
FOREIGN KEY(username) REFERENCES Users(username),
FOREIGN KEY(prefId) REFERENCES Preferences(prefId)
);

CREATE TABLE GuestSession(
gSessId INT PRIMARY KEY AUTO_INCREMENT,
timeReq TIMESTAMP,
timeAssgn TIMESTAMP,
timeAbnd TIMESTAMP,
numGuests INT
);

CREATE TABLE UsersSessHistory(
username VARCHAR(20) ,
gSessId INT,
PRIMARY KEY(username,gSessId),
FOREIGN KEY(username) REFERENCES Users(username),
FOREIGN KEY(gSessId) REFERENCES GuestSession(gSessId)
);

CREATE TABLE Address(
addressId INT PRIMARY KEY AUTO_INCREMENT,
geolat FLOAT(10,6),
geolng FLOAT(10,6),
country VARCHAR(30),
state VARCHAR(30),
city VARCHAR(30),
zip INT,
neibhd VARCHAR(30),
address VARCHAR(50)
);

CREATE TABLE RestChain(
restChainId INT PRIMARY KEY AUTO_INCREMENT,
restChainName VARCHAR(50)
);

CREATE TABLE Restaurant(
restId INT PRIMARY KEY AUTO_INCREMENT,
restName VARCHAR(50),
addressId INT,
restChainId INT,
FOREIGN KEY (addressId) REFERENCES Address(addressId),
FOREIGN KEY (restChainId) REFERENCES RestChain(restChainId)
);





CREATE TABLE Employee(
username VARCHAR(20) PRIMARY KEY,
firstName VARCHAR(15),
lastName VARCHAR(35),
passwrd VARCHAR(20) NOT NULL,
picId INT,
FOREIGN KEY(picId) REFERENCES Picture(picId)
);

CREATE TABLE EmpRestHistory(
username VARCHAR(20),
restId INT,
PRIMARY KEY(username,restId),
FOREIGN KEY(username) REFERENCES Employee(username),
FOREIGN KEY (restId) REFERENCES Restaurant(restId)
);

CREATE TABLE RestTable(
tableId INT PRIMARY KEY AUTO_INCREMENT,
numTable INT,
numSeats INT,
restId INT,
FOREIGN KEY (restId) REFERENCES Restaurant(restId)
);

CREATE TABLE TblDescription(
tblDescrId INT PRIMARY KEY AUTO_INCREMENT,
descr VARCHAR(50)
);

CREATE TABLE RTableDescr(
tblDescrId INT,
tableId INT,
PRIMARY KEY(tblDescrId,tableId),
FOREIGN KEY(tblDescrId) REFERENCES TblDescription(tblDescrId),
FOREIGN KEY(tableId) REFERENCES RestTable(tableId)
);

CREATE TABLE GSessionTableHistory(
tableId INT,
gSessId INT,
PRIMARY KEY (tableId,gSessId),
FOREIGN KEY(tableId) REFERENCES RestTable(tableId),
FOREIGN KEY(gSessId) REFERENCES GuestSession(gSessId)
);







