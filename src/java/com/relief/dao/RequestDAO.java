package com.relief.dao;

import com.relief.model.Request;
import com.relief.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM request";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                requests.add(extractRequestFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public Request getRequestById(int requestId) {
        Request request = null;
        String sql = "SELECT * FROM request WHERE requestid = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    request = extractRequestFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }

    public boolean updateRequestStatus(Request request) {
        String sql = "UPDATE request SET requeststatus = ? WHERE requestid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, request.getRequestStatus());
            ps.setInt(2, request.getRequestId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRequest(int requestId) {
        String sql = "DELETE FROM request WHERE requestid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addRequest(Request request) {
        String sql = "INSERT INTO request (resourceid, requestqty, requestdate, requeststatus, priority, name, email, phonenum, locationid) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, request.getResourceId());
            ps.setInt(2, request.getRequestQty());
            ps.setTimestamp(3, request.getRequestDate());
            ps.setString(4, request.getRequestStatus());
            ps.setString(5, request.getPriority());
            ps.setString(6, request.getName());
            ps.setString(7, request.getEmail());
            ps.setString(8, request.getPhonenum());
            ps.setInt(9, request.getLocationId());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Request extractRequestFromResultSet(ResultSet rs) throws SQLException {
        return new Request(
            rs.getInt("requestid"),
            rs.getInt("resourceid"),
            rs.getInt("requestqty"),
            rs.getTimestamp("requestdate"),
            rs.getString("requeststatus"),
            rs.getString("priority"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("phonenum"),
            rs.getInt("locationid")
        );
    }
    
    public int getTotalPendingRequests() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM request WHERE requeststatus = 'Pending'";
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
