DROP TABLE IF EXISTS Customer;
 
CREATE TABLE Customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  FirstName VARCHAR(250) NOT NULL,
  LastName VARCHAR(250) NOT NULL,
  PhoneNumber long,
  EmailAdress VARCHAR(250) NOT NULL,
  UserName VARCHAR(250) DEFAULT NULL,
  Age int
);