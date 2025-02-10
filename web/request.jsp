<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Aid</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
    <%@ include file="headerUser.jsp" %>
    <div class="request-help">
        <div class="container mt-4">
            <h1>Request</h1>
            <h2>Request Form</h2>
            <p>If you are in need of assistance, please fill out the form below and we will get back to you as soon as possible.</p>
            <form action="RequestUserServlet" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="phonenum">Phone Number:</label>
                    <input type="tel" class="form-control" id="phonenum" name="phonenum" required>
                </div>
                <div class="form-group">
                    <label for="resourceId">Resource:</label>
                    <select name="resourceId" class="form-control" id="resourceId" required>
                        <c:forEach items="${resources}" var="resource">
                            <option value="${resource.resourceId}">${resource.resourceId} - ${resource.resourceName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="locationId">Location:</label>
                    <select name="locationId" class="form-control" id="locationId" required>
                        <c:forEach items="${locations}" var="location">
                            <option value="${location.locationID}">${location.locationID} - ${location.reliefCenter}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="requestQty">Quantity:</label>
                    <input type="number" class="form-control" id="requestQty" name="requestQty" required>
                </div>
                <div class="form-group">
                    <label for="priority">Priority:</label>
                    <select class="form-control" id="priority" name="priority">
                        <option value="Low">Low</option>
                        <option value="Medium">Medium</option>
                        <option value="High">High</option>       
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Add Request</button>
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
