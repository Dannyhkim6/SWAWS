<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Location Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
        <h2>Location Management</h2>

        <form action="LocationController" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label>Location Name:</label>
                <input type="text" name="locationName" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Coordinate:</label>
                <input type="text" name="coordinate" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Population:</label>
                <input type="number" name="population" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Relief Center:</label>
                <input type="text" name="reliefCenter" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Add Location</button>
        </form>

        <h2>Location List</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Location ID</th>
                    <th>Name</th>
                    <th>Coordinate</th>
                    <th>Population</th>
                    <th>Relief Center</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${locations}" var="location">
                    <tr>
                        <td>${location.locationID}</td>
                        <td>${location.locationName}</td>
                        <td>${location.coordinate}</td>
                        <td>${location.population}</td>
                        <td>${location.reliefCenter}</td>
                        <td>
                            <a href="LocationController?action=view&locationID=${location.locationID}">View</a>
                            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>