<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Request Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
        <h2>Request Management</h2>

<!--        <form action="RequestController" method="post">
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
                        <option value="${resource.resourceID}">${resource.resourceName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="locationId">Location:</label>
                <select name="locationId" class="form-control" id="locationId" required>
                    <c:forEach items="${locations}" var="location">
                        <option value="${location.locationID}">${location.locationName}</option>
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
                    <option value="High">High</option>
                    <option value="Medium">Medium</option>
                    <option value="Low">Low</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Add Request</button>
        </form>-->

        <h3 class="mt-4">Request List</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Request ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Resource ID</th>
                    <th>Quantity</th>
                    <th>Request Date</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requests}" var="req">
                    <tr>
                        <td>${req.requestId}</td>
                        <td>${req.name}</td>
                        <td>${req.email}</td>
                        <td>${req.phonenum}</td>
                        <td>${req.resourceId}</td>
                        <td>${req.requestQty}</td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${req.requestDate}"/></td>
                        <td>${req.requestStatus}</td>
                        <td>${req.priority}</td>
                        <td>
                            <a href="RequestController?action=view&requestId=${req.requestId}">View</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
