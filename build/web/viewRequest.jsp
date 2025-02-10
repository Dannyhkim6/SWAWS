<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Request</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="container mt-4">
        <h2>Request Details</h2>

        <c:if test="${not empty selectedRequest}"> 
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th>Request ID:</th>
                        <td>${selectedRequest.requestId}</td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td>${selectedRequest.name}</td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>${selectedRequest.email}</td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>${selectedRequest.phonenum}</td>
                    </tr>
                    <tr>
                        <th>Resource ID:</th>
                        <td>${selectedRequest.resourceId}</td>
                    </tr>
                    <tr>
                        <th>Quantity:</th>
                        <td>${selectedRequest.requestQty}</td>
                    </tr>
                    <tr>
                        <th>Date:</th>
                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${selectedRequest.requestDate}"/></td>
                    </tr>
                    <tr>
                        <th>Priority:</th>
                        <td>${selectedRequest.priority}</td>
                    </tr>
                    <tr>
                        <th>Location ID:</th>
                        <td>${selectedRequest.locationId}</td>
                    </tr>
                </tbody>
            </table>

            <form action="RequestController" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="requestId" value="${selectedRequest.requestId}">

                <div class="form-group">
                    <label>Status:</label>
                    <select name="requestStatus" class="form-control">
                        <option value="Pending" ${selectedRequest.requestStatus == 'Pending' ? 'selected' : ''}>Pending</option>
                        <option value="Approved" ${selectedRequest.requestStatus == 'Approved' ? 'selected' : ''}>Approved</option>
                        <option value="Rejected" ${selectedRequest.requestStatus == 'Rejected' ? 'selected' : ''}>Rejected</option>
                        <option value="Completed" ${selectedRequest.requestStatus == 'Completed' ? 'selected' : ''}>Completed</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Update Status</button>
            </form>

        </c:if>

        <c:if test="${empty selectedRequest}">
            <p>No request found.</p>
        </c:if>

        <a href="RequestController" class="btn btn-secondary mt-3">Back to Request List</a>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>