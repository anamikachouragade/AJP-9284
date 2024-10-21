CREATE DATABASE ParkingLot;
use ParkingLot;

CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Admins
CREATE TABLE Admin (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Vehicles
CREATE TABLE Vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    vehicleNumber VARCHAR(20) NOT NULL UNIQUE,
    type ENUM('Car', 'Truck', 'Van', 'Motorcycle') NOT NULL,
    customerId INT,
    FOREIGN KEY (customerId) REFERENCES Customer(id) ON DELETE CASCADE
);

-- Table for Parking Slots
CREATE TABLE ParkingSlot (
    id INT PRIMARY KEY AUTO_INCREMENT,
    is_available BOOLEAN DEFAULT TRUE,
    vehicleNumber VARCHAR(20),  -- Column to store the assigned vehicle's number
    FOREIGN KEY (vehicleNumber) REFERENCES Vehicle(vehicleNumber) ON DELETE SET NULL
);



show DATABASES ;
show tables;
select * from admin;
SELECT username, password FROM Admin WHERE username = "anamika" AND password = "anamika26_4";
SELECT vehicle FROM ParkingTicket ;
Delete  from Vehicle where id=1;
