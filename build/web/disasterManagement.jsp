<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Disaster Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
        <h2>Disaster Management</h2>
        <form action="DisasterController" method="post">
            <div class="form-group">
                <label>Disaster Name:</label>
                <input type="text" name="disasterName" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Type:</label>
                <select name="disasterType" class="form-control" required>
                    <option value="Flood">Flood</option>
                    <option value="Earthquake">Earthquake</option>
                    <option value="Fire">Fire</option>
                    <option value="Landslide">Landslide</option>
                    <option value="Other">Other</option>
                </select>
            </div>
<!--            <div class="form-group">
                <label>Nearby Relief Center ID:</label> 
                <input type="number" name="disasterLoc" class="form-control" required> 
            </div>-->
            <div class="form-group">
                <label for="disasterLoc">Nearby Relief Center:</label>
                <select name="disasterLoc" id="disasterLoc" class="form-control" required>
                    <c:forEach items="${locations}" var="loc">
                        <option value="${loc.locationID}">${loc.locationID} - ${loc.reliefCenter}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Description:</label>
                <textarea name="description" class="form-control"></textarea>
            </div>
            <div class="form-group">
                <label>Severity:</label>
                <select name="severity" class="form-control" required>
                    <option value="Low">Low</option>
                    <option value="Moderate">Moderate</option>
                    <option value="Severe">Severe</option>
                    <option value="Critical">Critical</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add Disaster</button>
        </form>

        <h3 class="mt-4">Disaster List</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
<!--                    <th>Nearby Relief Center</th>-->
                    <th>Location</th>
                    <th>Severity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${disasters}" var="disaster">
                    <tr>
                        <td>${disaster.disasterID}</td>
                        <td>${disaster.disasterName}</td>
                        <td>${disaster.disasterType}</td>
                        <td>
                            ${disaster.locationName}
                        </td> <!-- Display location name instead of ID -->
                        <td>${disaster.severity}</td>
                        
                        <td>
                            <a href="ViewDisasterServlet?disasterID=${disaster.disasterID}">View</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:if test="${not empty errorMessage}"> 
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        <form action="DisasterController" method="post"> 
            </form>
    </div>

    
    <%@ include file="footer.jsp" %>
</body>
</html>