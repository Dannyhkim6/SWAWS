package com.relief.util;

import java.sql.*;

public class TableCreation {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/DisasterDB;create=true");
             Statement stmt = conn.createStatement()) {

            // User Table
            String createUserTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "user_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(255) NOT NULL UNIQUE," +
                    "password VARCHAR(255) NOT NULL," +
                    "role VARCHAR(255)," +
                    "fullname VARCHAR(255)," +
                    "phonenum VARCHAR(20)," +
                    "email VARCHAR(255)" +
                    ")";
            stmt.executeUpdate(createUserTable);

            // User Record
            String insertUser = "INSERT INTO users (username, password, role, fullname, phonenum, email) " +
                    "VALUES ('admin', 'admin123', 'Admin', 'Admin SWAWS', '012-3007886', 'admin@swaws.com')";
            stmt.executeUpdate(insertUser);

            // Disaster Table
            String createDisasterTable = "CREATE TABLE IF NOT EXISTS disaster (" +
                    "disaster_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "disaster_name VARCHAR(255) NOT NULL," +
                    "disaster_type VARCHAR(255)," +
                    "disaster_loc INT," +
                    "disaster_date TIMESTAMP," +
                    "description TEXT," +
                    "severity VARCHAR(255)," +
                    "FOREIGN KEY (disaster_loc) REFERENCES location(location_id)" +
                    ")";
            stmt.executeUpdate(createDisasterTable);

            // Disaster Records
            String[] disasterData = {
                    "('Flood in Shah Alam', 'Flood', 19, '2025-02-09 19:27:22.000', 'Heavy rainfall caused widespread flooding in Shah Alam.', 'Moderate')",
                    "('Flood in Shah Alam', 'Flood', 1, '2024-12-20 10:00:00.000', 'Heavy rainfall caused widespread flooding in Shah Alam.', 'Moderate')",
                    "('Earthquake in Kuala Lumpur', 'Earthquake', 2, '2024-12-21 15:30:00.000', 'A moderate earthquake struck Kuala Lumpur.', 'Severe')",
                    "('Fire in Georgetown', 'Fire', 3, '2024-12-22 08:00:00.000', 'A fire broke out in a residential area of Georgetown.', 'Moderate')"
            };
            for (String data : disasterData) {
                String insertDisaster = "INSERT INTO disaster (disaster_name, disaster_type, disaster_loc, disaster_date, description, severity) VALUES " + data;
                stmt.executeUpdate(insertDisaster);
            }

            // Location Table
            String createLocationTable = "CREATE TABLE IF NOT EXISTS location (" +
                    "location_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "location_name VARCHAR(255) NOT NULL," +
                    "coordinate VARCHAR(50)," +
                    "population INT," +
                    "relief_center VARCHAR(255)" +
                    ")";
            stmt.executeUpdate(createLocationTable);

            //  Location Records
            String[] locationData = {
                    "('Kuala Lumpur', '3.1390, 101.6869', 1800000, 'KL Relief Center')",
                    "('Johor Bahru', '1.4927, 103.7414', 500000, 'JB Disaster Response Hub')",
                    "('Penang Island', '5.4141, 100.3288', 750000, 'Penang Emergency Shelter')",
                    "('Kuantan', '3.8077, 103.3260', 450000, 'Kuantan Flood Relief Center')",
                    "('Kota Bharu', '6.1254, 102.2381', 600000, 'KB Disaster Aid Center')",
                    "('Ipoh', '101.0633,4.5975', 750000, 'Perak Relief Center')",
                    "('Malacca', '102.2514,2.1896', 300000, 'Malacca Relief Center')",
                    "('Shah Alam', '101.5412,3.0738', 600000, 'Selangor Relief Center')",
                    "('Petaling Jaya', '101.6500,3.1000', 900000, 'PJ Relief Center')"
            };
            for (String data : locationData) {
                String insertLocation = "INSERT INTO location (location_name, coordinate, population, relief_center) VALUES " + data;
                stmt.executeUpdate(insertLocation);
            }

            // ReliefResource Table
            String createReliefResourceTable = "CREATE TABLE IF NOT EXISTS reliefresource (" +
                    "resource_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "resource_name VARCHAR(255) NOT NULL," +
                    "resource_type VARCHAR(255)," +
                    "resource_qty INT," +
                    "resource_status VARCHAR(255)," +
                    "location_id INT," +
                    "last_updated TIMESTAMP," +
                    "FOREIGN KEY (location_id) REFERENCES location(location_id)" +
                    ")";
            stmt.executeUpdate(createReliefResourceTable);

            // ReliefResource Records
            String[] reliefResourceData = {
                    "('makanan1', 'Food', 100, 'Out of Stock', 1, '2025-02-05 22:20:20.000')",
                    "('Rice', 'Food', 100, 'Available', 1, '2025-02-09 13:18:05.355')",
                    "('Water', 'Food', 200, 'Available', 2, '2025-02-09 13:18:05.355')",
                    "('Medical Kit', 'Medical', 50, 'Available', 3, '2025-02-09 13:18:05.355')",
                    "('Blankets', 'Shelter', 30, 'Low Stock', 4, '2025-02-09 13:18:05.355')",
                    "('Food Pack', 'Food', 60, 'Available', 8, '2025-02-09 13:18:05.355')",
                    "('Sleeping Bags', 'Shelter', 40, 'Available', 10, '2025-02-09 13:18:05.355')",
                    "('Food Bank Family 5 package', 'Food', 150, 'Available', 19, '2025-02-09 19:35:27.841')"
            };
            for (String data : reliefResourceData) {
                String insertReliefResource = "INSERT INTO reliefresource (resource_name, resource_type, resource_qty, resource_status, location_id, last_updated) VALUES " + data;
                stmt.executeUpdate(insertReliefResource);
            }

            // Request Table
            String createRequestTable = "CREATE TABLE IF NOT EXISTS request (" +
                    "request_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "resource_id INT," +
                    "request_qty INT," +
                    "request_date TIMESTAMP," +
                    "request_status VARCHAR(255)," +
                    "priority VARCHAR(255)," +
                    "name VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "phonenum VARCHAR(20)," +
                    "location_id INT," +
                    "FOREIGN KEY (resource_id) REFERENCES reliefresource(resource_id)," +
                    "FOREIGN KEY (location_id) REFERENCES location(location_id)" +
                    ")";
            stmt.executeUpdate(createRequestTable);

            // Request Records
            String[] requestData = {
                    "(1, 15, '2025-02-08 16:50:25.167', 'Completed', 'High', 'John Doe', 'john@example.com', '0123456789', 10)",
                    "(24, 6, '2025-02-09 18:34:25.120', 'Pending', 'Medium', 'Arshad Ali', 'AA@swaws.com', '0198987677', 19)",
                    "(27, 1, '2025-02-09 19:37:00.265', 'Pending', 'High', 'Soleh Solah', 'soless@swaws.com', '0128009008', 19)",
                    "(20, 3, '2025-02-10 01:07:04.111', 'Pending', 'Low', 'Ayu mai', 'ayumai@uitm.com', '0193232001', 4)"
            };
            for (String data : requestData) {
                String insertRequest = "INSERT INTO request (resource_id, request_qty, request_date, request_status, priority, name, email, phonenum, location_id) VALUES " + data;
                stmt.executeUpdate(insertRequest);
            }

            //  Volunteer Table
            String createVolunteerTable = "CREATE TABLE IF NOT EXISTS volunteer (" +
                    "volunteer_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "nric VARCHAR(20)," +
                    "email VARCHAR(255)," +
                    "phonenum VARCHAR(20)," +
                    "area_of_interest VARCHAR(255)," +
                    "reason TEXT," +
                    "status VARCHAR(255)," +
                    "gender VARCHAR(20)" +
                    ")";
            stmt.executeUpdate(createVolunteerTable);

            // Volunteer Records
            String[] volunteerData = {
                    "('john doe', '123456789012', 'johndoe@gmail.com', '0123456789', 'Medical', 'cuba insert', 'Pending', 'Male')",
                    "('alissa', '030402089731', 'alis@swaws.com', '0176665555', 'First Aid', 'test', 'Declined', 'Female')",
                    "('Danny Hakim', '030405140093', 'bo6ddy@swaws.com', '0178997675', 'Rescue', 'I have passion to helping people', 'Approved', 'Male')",
                    "('Ayu sarah', '030303120120', 'ayusarah@uitm.com', '0134567231', 'Community Support', 'I love helping people in need, it motivates me to continue to be grateful.', 'Approved', 'Female')"
            };
            for (String data : volunteerData) {
                String insertVolunteer = "INSERT INTO volunteer (name, nric, email, phonenum, area_of_interest, reason, status, gender) VALUES " + data;
                stmt.executeUpdate(insertVolunteer);
            }

            System.out.println("Tables created and records inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}