package com.relief.dao;

import com.relief.model.ReliefResource;
import com.relief.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReliefResourceDAO {

    public List<ReliefResource> getAllReliefResources() {
        List<ReliefResource> resources = new ArrayList<>();
        String sql = "SELECT * FROM ReliefResource";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ReliefResource resource = new ReliefResource(
                        rs.getInt("resourceId"),
                        rs.getString("resourceName"),
                        rs.getString("resourceType"),
                        rs.getString("resourceStatus"),
                        rs.getInt("locationId"),
                        rs.getInt("resourceQty"),
                        rs.getTimestamp("lastUpdated")
                );
                resources.add(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resources;
    }


    public ReliefResource getReliefResourceById(int resourceId) {
        ReliefResource resource = null;
        String sql = "SELECT * FROM ReliefResource WHERE resourceId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, resourceId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                resource = new ReliefResource(
                        rs.getInt("resourceId"),
                        rs.getString("resourceName"),
                        rs.getString("resourceType"),
                        rs.getString("resourceStatus"),
                        rs.getInt("locationId"),
                        rs.getInt("resourceQty"), 
                        rs.getTimestamp("lastUpdated")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resource;
    }


    public boolean addReliefResource(ReliefResource resource) {
        String sql = "INSERT INTO ReliefResource (resourceName, resourceType, resourceStatus, locationId, resourceQty, lastUpdated) " +
                     "VALUES (?, ?, ?, ?, ?, ?)"; 

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, resource.getResourceName());
            pstmt.setString(2, resource.getResourceType());
            pstmt.setString(3, resource.getResourceStatus());
            pstmt.setInt(4, resource.getLocationId());
            pstmt.setInt(5, resource.getResourceQty());
            pstmt.setTimestamp(6, resource.getLastUpdated());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateReliefResource(ReliefResource resource) {
        String sql = "UPDATE ReliefResource SET resourceName = ?, resourceType = ?, resourceStatus = ?, locationId = ?, resourceQty = ? " +
                     "WHERE resourceId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, resource.getResourceName());
            pstmt.setString(2, resource.getResourceType());
            pstmt.setString(3, resource.getResourceStatus());
            pstmt.setInt(4, resource.getLocationId());
            pstmt.setInt(5, resource.getResourceQty());
            pstmt.setInt(6, resource.getResourceId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteReliefResource(int resourceId) {
        String sql = "DELETE FROM ReliefResource WHERE resourceId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, resourceId);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getTotalResources() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM ReliefResource";
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