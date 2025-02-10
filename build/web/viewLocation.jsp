<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Location Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>    
        <%@ include file="header.jsp" %>
        <div class="container mt-4">
            <h2>Location Details</h2>
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th>Name:</th>
                        <td>${location.locationName}</td>
                    </tr>
                    <tr>
                        <th>Coordinate:</th>
                        <td>${location.coordinate}</td>
                    </tr>
                    <tr>
                        <th>Population:</th>
                        <td>${location.population}</td>
                    </tr>
                    <tr>
                        <th>Relief Center:</th>
                        <td>${location.reliefCenter}</td>
                    </tr>
                </tbody>
            </table>

            <form action="LocationController" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="locationID" value="${location.locationID}">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="locationName" class="form-control" value="${location.locationName}">
                </div>
                <div class="form-group">
                    <label>Coordinate:</label>
                    <input type="text" name="coordinate" class="form-control" value="${location.coordinate}">
                </div>
                <div class="form-group">
                    <label>Population:</label>
                    <input type="number" name="population" class="form-control" value="${location.population}">
                </div>
                <div class="form-group">
                    <label>Relief Center:</label>
                    <input type="text" name="reliefCenter" class="form-control" value="${location.reliefCenter}">
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>

            <button type="button" class="btn btn-danger" onclick="confirmDelete(${location.locationID})">Delete</button>

            <a href="LocationController" class="btn btn-secondary">Back to Location List</a>
        </div>

        <script>
            function confirmDelete(locationID) {
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
                        window.location.href = "LocationController?action=delete&locationID=" + locationID;
                    }
                })
            }
        </script>

        <%@ include file="footer.jsp" %>
    </body>
</html>