package com.relief.dao;

import com.relief.model.Volunteer;
import com.relief.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolunteerDAO {

    public boolean addVolunteer(Volunteer volunteer) {
    String sql = "INSERT INTO volunteer (name, nric, email, phoneNum, gender, areaOfInterest, reason, status) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstmt.setString(1, volunteer.getName());
        pstmt.setString(2, volunteer.getNric());
        pstmt.setString(3, volunteer.getEmail());
        pstmt.setString(4, volunteer.getPhoneNum());
        pstmt.setString(5, volunteer.getGender());
        pstmt.setString(6, volunteer.getAreaOfInterest());
        pstmt.setString(7, volunteer.getReason());
        pstmt.setString(8, volunteer.getStatus());

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                volunteer.setVolunteerID(rs.getInt(1));
            }
            return true;
        } else {
            System.err.println("❌ Volunteer registration failed!");
            return false;
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("❌ Error adding volunteer: " + e.getMessage());
        return false;
    }
}


    public List<Volunteer> getAllVolunteers() {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql = "SELECT * FROM volunteer";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Volunteer volunteer = new Volunteer(
                        rs.getInt("volunteerID"),
                        rs.getString("name"),
                        rs.getString("nric"),
                        rs.getString("email"),
                        rs.getString("phoneNum"),
                        rs.getString("areaOfInterest"),
                        rs.getString("reason"),
                        rs.getString("status"),
                        rs.getString("gender")
                );
                volunteers.add(volunteer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return volunteers;
    }

    public Volunteer getVolunteerById(int volunteerID) {
        Volunteer volunteer = null;
        String sql = "SELECT * FROM volunteer WHERE volunteerID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, volunteerID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                volunteer = new Volunteer(
                        rs.getInt("volunteerID"),
                        rs.getString("name"),
                        rs.getString("nric"),
                        rs.getString("email"),
                        rs.getString("phoneNum"),
                        rs.getString("areaOfInterest"),
                        rs.getString("reason"),
                        rs.getString("status"),
                        rs.getString("gender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return volunteer;
    }

    public boolean updateVolunteerStatus(Volunteer volunteer) {
        String sql = "UPDATE volunteer SET status = ? WHERE volunteerID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, volunteer.getStatus()); 
            pstmt.setInt(2, volunteer.getVolunteerID()); 
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteVolunteer(int volunteerID) {
        String sql = "DELETE FROM volunteer WHERE volunteerID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, volunteerID);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace(); 
            System.err.println("Error deleting volunteer: " + e.getMessage()); 
            return false; 
        }
    }
    
    public int getTotalApprovedVolunteers() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM volunteer WHERE status = 'Approved'";
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