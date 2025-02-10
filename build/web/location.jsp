<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Location</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
            <%@ include file="headerUser.jsp" %>

    <div class="locations-section">
        <h1>Location</h1>
        <h2>Find Nearby Relief Centers</h2>
        <p>Below is a list of places you can go to during a disaster for safety, resources, and assistance.</p>
   
    <section id="incidents" class="section-disaster">

    <h2>Location List</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Location ID</th>
                        <th>Name</th>
                        <th>Coordinate</th>
                        <th>Population</th>
                        <th>Relief Center</th>
<!--                        <th>Actions</th>-->
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
<!--                            <td>
                                <a href="LocationListServlet?action=view&locationID=${location.locationID}">View</a>
                                </td>-->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </section>
    </div>

    <%@ include file="footer.jsp" %>

</body>
</html>
