package com.relief.dao;

import com.relief.model.Disaster;
import com.relief.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisasterDAO {
    
    public List<Disaster> getAllDisasters() {
    List<Disaster> disasters = new ArrayList<>();
    String sql = "SELECT d.*, l.locationName FROM disaster d " +
                 "JOIN location l ON d.disasterLoc = l.locationID"; // Join with location table

    try (Connection conn = DBUtil.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Disaster disaster = new Disaster(
                rs.getInt("disasterID"),
                rs.getString("disasterName"),
                rs.getString("disasterType"),
                rs.getInt("disasterLoc"),
                rs.getString("disasterDate"),
                rs.getString("description"),
                rs.getString("severity")
            );
            disaster.setLocationName(rs.getString("locationName")); 
            disasters.add(disaster);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return disasters;
}

    public boolean addDisaster(Disaster disaster) {
        String sql = "INSERT INTO disaster (disasterName, disasterType, disasterLoc, disasterDate, description, severity) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, disaster.getDisasterName());
            pstmt.setString(2, disaster.getDisasterType());
            pstmt.setInt(3, disaster.getDisasterLoc());
            pstmt.setString(4, disaster.getDisasterDate());
            pstmt.setString(5, disaster.getDescription());
            pstmt.setString(6, disaster.getSeverity());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error adding disaster: " + e.getMessage());
            return false; 
        }
    }
    
    public Disaster getDisasterById(int disasterID) {
        Disaster disaster = null;
        String sql = "SELECT d.*, l.locationName FROM disaster d " +
                "JOIN location l ON d.disasterLoc = l.locationID " +
                "WHERE d.disasterID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, disasterID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                disaster = new Disaster(
                        rs.getInt("disasterID"),
                        rs.getString("disasterName"),
                        rs.getString("disasterType"),
                        rs.getInt("disasterLoc"),
                        rs.getString("disasterDate"),
//                        disaster.setDisasterDate(rs.getTimestamp("disasterDate"));
                        rs.getString("description"),
                        rs.getString("severity")
                );
                disaster.setLocationName(rs.getString("locationName")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disaster;
    }

    public boolean updateDisaster(Disaster disaster) {
        String sql = "UPDATE disaster SET disasterName = ?, disasterType = ?, disasterLoc = ?, disasterDate = ?, description = ?, severity = ? " +
                "WHERE disasterID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, disaster.getDisasterName());
            pstmt.setString(2, disaster.getDisasterType());
            pstmt.setInt(3, disaster.getDisasterLoc());
            pstmt.setString(4, disaster.getDisasterDate());
//            pstmt.setTimestamp(4, disaster.getDisasterDate());
            pstmt.setString(5, disaster.getDescription());
            pstmt.setString(6, disaster.getSeverity());
            pstmt.setInt(7, disaster.getDisasterID()); 

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDisaster(int disasterID) {
        String sql = "DELETE FROM disaster WHERE disasterID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, disasterID);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTotalDisasters() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM disaster";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
