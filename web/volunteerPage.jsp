<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Volunteer Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
 <!--       <h2>Volunteer Registration</h2>
        <form action="VolunteerController" method="post"> 
            <div class="form-group">
                <label>Name:</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="form-group">
                <label>NRIC:</label>
                <input type="text" name="nric" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Phone Number:</label>
                <input type="text" name="phoneNum" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <select name="gender" class="form-control" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            <div class="form-group">
                <label>Area of Interest:</label>
                <select name="areaOfInterest" class="form-control" required>
                    <option value="Medical">Medical</option> 
                    <option value="First Aid">First Aid</option>
                    <option value="Logistics">Logistics</option>
                    <option value="Rescue">Rescue</option>
                    <option value="Community Support">Community Support</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label>Reason for Volunteering:</label>
                <textarea name="reason" class="form-control" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>-->

        <h2>Volunteer List</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>NRIC</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Area of Interest</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${volunteers}" var="volunteer">
                    <tr>
                        <td>${volunteer.name}</td>
                        <td>${volunteer.nric}</td>
                        <td>${volunteer.gender}</td>
                        <td>${volunteer.email}</td>
                        <td>${volunteer.phoneNum}</td>
                        <td>${volunteer.areaOfInterest}</td>
                        <td>${volunteer.status}</td>
                        <td>
                            <a href="ViewVolunteerServlet?volunteerID=${volunteer.volunteerID}">View</a> 
                            <c:if test="${isAdmin}"> 
                                <a href="EditVolunteerServlet?volunteerID=${volunteer.volunteerID}">Edit</a> 
                                <a href="DeleteVolunteerServlet?volunteerID=${volunteer.volunteerID}">Delete</a> 
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>