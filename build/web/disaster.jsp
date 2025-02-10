<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Disaster</title>
    <link rel="stylesheet" href="CSS/style.css">
<!--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">-->
</head>
<body>
        <%@ include file="headerUser.jsp" %>

    <section class="incidents-hero">
        <div class="hero-overlay">
            <h1>Recent Natural Disasters in Malaysia</h1>
            <p>Stay informed about the latest incidents and their impact.</p>
        </div>
    </section>

    <section id="incidents" class="section-disaster">
        <h3 class="mt-4">Disaster List</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Location</th>
<!--                    <th>Nearby Relief Center</th>-->
                    <th>Severity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${disasters}" var="disaster">
                    <tr>
                        <td>${disaster.disasterID}</td>
                        <td>${disaster.disasterName}</td>
                        <td>${disaster.disasterType}</td>
                        <td>${disaster.locationName}</td> 
                        <td>${disaster.severity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <%@ include file="footer.jsp" %>

</body>
</html>