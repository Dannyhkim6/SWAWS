<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View Disaster</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>    
        <%@ include file="header.jsp" %>
        <div class="container mt-4">
            <h2>View Disaster Details</h2>
            <c:if test="${not empty disaster}"> 
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Disaster ID:</th>
                            <td>${disaster.disasterID}</td>
                        </tr>
                        <tr>
                            <th>Name:</th>
                            <td>${disaster.disasterName}</td>
                        </tr>
                        <tr>
                            <th>Type:</th>
                            <td>${disaster.disasterType}</td>
                        </tr>
                        <tr>
                            <th>Location:</th> 
                            <td>${disaster.locationName}</td> 
                        </tr>
                        <tr>
                            <th>Date:</th>
                            <td>${disaster.disasterDate}</td>
                        </tr>
                        <tr>
                            <th>Description:</th>
                            <td>${disaster.description}</td>
                        </tr>
                        <tr>
                            <th>Severity:</th>
                            <td>${disaster.severity}</td>
                        </tr>
                    </tbody>
                </table>

                <form action="DisasterController" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="disasterID" value="${disaster.disasterID}">
                    <div class="form-group">
                        <label>Name:</label>
                        <input type="text" name="disasterName" class="form-control" value="${disaster.disasterName}">
                    </div>
                    <div class="form-group">
                        <label>Type:</label>
                        <select name="disasterType" class="form-control">
                            <option value="${disaster.disasterType}" selected>${disaster.disasterType}</option> 
                            <option value="Flood">Flood</option>
                            <option value="Earthquake">Earthquake</option>
                            <option value="Fire">Fire</option>
                            <option value="Landslide">Landslide</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Location:</label>
                        <select name="disasterLoc" class="form-control" required>
                            <c:forEach items="${locations}" var="loc">
                                <option value="${loc.locationID}" ${loc.locationID == disaster.disasterLoc ? 'selected' : ''}>
                                    ${loc.locationID} - ${loc.reliefCenter}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Date:</label>
                        <input type="datetime-local" name="disasterDate" class="form-control" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${disaster.disasterDate}'/>"> 
                    </div>
                    <div class="form-group">
                        <label>Description:</label>
                        <textarea name="description" class="form-control">${disaster.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Severity:</label>
                        <select name="severity" class="form-control">
                            <option value="${disaster.severity}" selected>${disaster.severity}</option> 
                            <option value="Low">Low</option>
                            <option value="Moderate">Moderate</option>
                            <option value="Severe">Severe</option>
                            <option value="Critical">Critical</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Update</button>
                </form>


                <button type="button" class="btn btn-danger" onclick="confirmDelete(${disaster.disasterID})">Delete</button>

            </c:if>
            <c:if test="${empty disaster}">
                <p>No disaster found.</p>
            </c:if>
            <a href="DisasterController" class="btn btn-secondary">Back to Disaster List</a>
        </div>
        <script>
            function confirmDelete(disasterID) {
                Swal.fire({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#d33',
                    cancelButtonColor: '#3085d6',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "DeleteDisasterServlet?disasterID=" + disasterID;
                    }
                })
            }
        </script>
        <%@ include file="footer.jsp" %>
    </body>
</html>
