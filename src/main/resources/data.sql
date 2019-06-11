/* Address Table */
DROP TABLE IF EXISTS Address;
 
CREATE TABLE Address (
  address_Id INT PRIMARY KEY,
  street VARCHAR(100) NOT NULL,
  city VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  postal_code VARCHAR(7) NOT NULL
);
 
INSERT INTO Address (address_Id, street, city, state, postal_code) VALUES
  (100, '100 City Centre Dr', 'Mississauga', 'ON', 'L5B 2C9'),
  (101, '3401 Dufferin St', 'North York', 'ON', 'M6A 2T9'),
  (200, '701 W Georgia St', 'Vancouver', 'BC', 'V7Y 1G5');
  
  
/* User Table */
DROP TABLE IF EXISTS User;
 
CREATE TABLE User (
  user_Id INT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  cell VARCHAR(14) DEFAULT NULL,
  occupation VARCHAR(100) DEFAULT NULL,
  address_Id INT NOT NULL,
  FOREIGN KEY (address_Id) REFERENCES Address (address_Id)
);
 
INSERT INTO User (user_Id, first_name, last_name, email, cell, occupation, address_Id) VALUES
  (1001, 'Issa', 'Ennab', 'eennab@gmail.com', '647-990-6222', 'Software Developer', 100),
  (1002, 'John', 'Smith', 'johnsmith@gmail.com', '403-221-7878', 'Doctor', 200);
  
  
/* User Whatever 
DROP TABLE IF EXISTS Whatever;
 
CREATE TABLE Whatever (
  id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
);
 
INSERT INTO Whatever (id, name, email) VALUES
  (1001, 'Issa', 'eennab@gmail.com'),
  (1002, 'John', 'johnsmith@gmail.com');
 */
  
