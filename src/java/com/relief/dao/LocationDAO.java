package com.relief.dao;

import com.relief.model.Location;
import com.relief.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {

    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM location";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Location location = new Location(
                        rs.getInt("locationID"),
                        rs.getString("locationName"),
                        rs.getString("coordinate"),
                        rs.getInt("population"),
                        rs.getString("reliefCenter")
                );
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    public Location getLocationById(int locationID) {
        Location location = null;
        String sql = "SELECT * FROM location WHERE locationID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, locationID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                location = new Location(
                        rs.getInt("locationID"),
                        rs.getString("locationName"),
                        rs.getString("coordinate"),
                        rs.getInt("population"),
                        rs.getString("reliefCenter")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return location;
    }

    public boolean addLocation(Location location) {
        String sql = "INSERT INTO location (locationName, coordinate, population, reliefCenter) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, location.getLocationName());
            pstmt.setString(2, location.getCoordinate());
            pstmt.setInt(3, location.getPopulation());
            pstmt.setString(4, location.getReliefCenter());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteLocation(int locationID) {
        String sql = "DELETE FROM location WHERE locationID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, locationID);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateLocation(Location location) {
        String sql = "UPDATE location SET locationName = ?, coordinate = ?, population = ?, reliefCenter = ? WHERE locationID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, location.getLocationName());
            pstmt.setString(2, location.getCoordinate());
            pstmt.setInt(3, location.getPopulation());
            pstmt.setString(4, location.getReliefCenter());
            pstmt.setInt(5, location.getLocationID());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String getReliefCenterByLocationId(int locationID) {
        String reliefCenter = null;
        String sql = "SELECT reliefCenter FROM location WHERE locationID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, locationID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    reliefCenter = rs.getString("reliefCenter");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reliefCenter;
    }

}