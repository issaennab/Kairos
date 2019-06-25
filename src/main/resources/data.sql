/* User Table */
DROP TABLE IF EXISTS User;
 
CREATE TABLE User (
  user_Id INT PRIMARY KEY,
  handle VARCHAR(100) DEFAULT NULL,
  open_Id INT DEFAULT NULL
);
 
INSERT INTO User (user_Id, handle, open_Id) VALUES
  (1101, 'Handle 1', 1),
  (1102, 'Handle 2', 2);

/* Address Table */
DROP TABLE IF EXISTS Address;
 
CREATE TABLE Address (
  address_Id INT PRIMARY KEY,
  address1 VARCHAR(100) NOT NULL,
  address2 VARCHAR(100) DEFAULT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  postal_code VARCHAR(7) NOT NULL,
  country VARCHAR(7) NOT NULL
);
 
INSERT INTO Address (address_Id, address1, address2, city, state, postal_code, country) VALUES
  (100, '100 City Centre Dr', null, 'Mississauga', 'ON', 'L5B 2C9', 'Canada'),
  (101, '3401 Dufferin St', null, 'North York', 'ON', 'M6A 2T9', 'Canada'),
  (200, '701 W Georgia St', null, 'Vancouver', 'BC', 'V7Y 1G5', 'Canada');
  
  
/* User Table */
DROP TABLE IF EXISTS Profile;
 
CREATE TABLE Profile (
  profile_Id INT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  cell VARCHAR(14) DEFAULT NULL,
  occupation VARCHAR(100) DEFAULT NULL,
  profile_picture VARCHAR(100) DEFAULT NULL,
  alias_Id INT,
  address_Id INT,
  user_Id INT NULL,
  FOREIGN KEY (address_Id) REFERENCES Address (address_Id),
  FOREIGN KEY (user_Id) REFERENCES User (user_Id),
);
 
INSERT INTO profile (profile_Id, first_name, last_name, email, cell, occupation, address_Id, alias_Id, user_Id) VALUES
  (1001, 'Issa', 'Ennab', 'eennab@gmail.com', '647-990-6222', 'Software Developer', 100, 0, 1101),
  (1002, 'John', 'Smith', 'johnsmith@gmail.com', '403-221-7878', 'Doctor', 200, 0, 1102);
  
  
/* User Table */
DROP TABLE IF EXISTS Contact;
 
CREATE TABLE Contact (
  contact_Id INT PRIMARY KEY,
  label VARCHAR(100) DEFAULT NULL,
  contact_info VARCHAR(100) DEFAULT NULL,
  profile_Id INT DEFAULT NULL,
  FOREIGN KEY (profile_Id) REFERENCES Profile (profile_Id)
);
 
INSERT INTO Contact (contact_Id, label, contact_info, profile_Id) VALUES
  (1, 'Label 1', 'contact info 1', 1001),
  (2, 'Label 2', 'contact info 2', 1002);
  
