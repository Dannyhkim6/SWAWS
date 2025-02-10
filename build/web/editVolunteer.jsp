<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Volunteer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
        <h2>Edit Volunteer</h2>
        <div class="container mt-4">
        <h2>Volunteer Details</h2>
        <table class="table table-bordered">
            <tbody>
                <tr>
                    <th>Name:</th>
                    <td>${volunteer.name}</td>
                </tr>
                <tr>
                    <th>NRIC/ID:</th>
                    <td>${volunteer.nric}</td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td>${volunteer.gender}</td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>${volunteer.email}</td>
                </tr>
                <tr>
                    <th>Phone Number:</th>
                    <td>${volunteer.phoneNum}</td>
                </tr>
                <tr>
                    <th>Area of Interest:</th>
                    <td>${volunteer.areaOfInterest}</td>
                </tr>
                <tr>
                    <th>Reason for Volunteering:</th>
                    <td>${volunteer.reason}</td>
                </tr>
                <tr>
                    <th>Status:</th>
                    <td>${volunteer.status}</td>
                </tr>
            </tbody>
        </table>
        <form action="EditVolunteerServlet" method="post">
            <input type="hidden" name="volunteerID" value="${volunteer.volunteerID}">
            <div class="form-group">
                <label>Status:</label>
                <select name="status" class="form-control">
                    <option value="Pending">Pending</option>
                    <option value="Approved">Approved</option>
                    <option value="Declined">Declined</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
        <a href="VolunteerController" class="btn btn-secondary">Back to Volunteer List</a>
    </div>
        
    </div>
</body>
</html>