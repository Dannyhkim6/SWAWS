<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Resource Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
        <h2>Resource Management</h2>

        <form action="ReliefResourceController" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="resourceName">Resource Name:</label>
                <input type="text" class="form-control" id="resourceName" name="resourceName" required>
            </div>
            <div class="form-group">
                <label for="resourceType">Resource Type:</label>
                <select class="form-control" id="resourceType" name="resourceType" required>
                    <option value="Food">Food</option>
                    <option value="Medical">Medical</option>
                    <option value="Shelter">Shelter</option>
                    <option value="Clothing">Clothing</option>
                    <option value="etc">etc</option>
                </select>    
            </div>
            <div class="form-group">
                <label for="resourceStatus">Resource Status:</label>
                <select name="resourceStatus" class="form-control">
                    <option value="Available" ${resource.resourceStatus == 'Available' ? 'selected' : ''}>Available</option>
                    <option value="Low Stock" ${resource.resourceStatus == 'Low Stock' ? 'selected' : ''}>Low Stock</option>
                    <option value="Out of Stock" ${resource.resourceStatus == 'Out of Stock' ? 'selected' : ''}>Out of Stock</option>
                </select>
            </div>
            <div class="form-group">
                <label for="locationId">Location:</label>
                <select name="locationId" id="locationId" class="form-control" required>
                    <c:forEach items="${locations}" var="loc">
                        <option value="${loc.locationID}">${loc.locationID} - ${loc.reliefCenter}</option>
                    </c:forEach>
                </select>
            </div>
            <!-- Added missing resourceQty input field -->
            <div class="form-group">
                <label for="resourceQty">Resource Quantity:</label>
                <input type="number" class="form-control" id="resourceQty" name="resourceQty" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Resource</button>
        </form>

        <h3 class="mt-4">Resource List</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Resource ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Location ID</th>
                    <th>Quantity</th>  <!-- Display quantity -->
                    <th>Last Updated</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${resources}" var="resource">
                    <tr>
                        <td>${resource.resourceId}</td>
                        <td>${resource.resourceName}</td>
                        <td>${resource.resourceType}</td>
                        <td>${resource.resourceStatus}</td>
                        <td>${resource.locationId}</td>
                        <td>${resource.resourceQty}</td> <!-- Display quantity -->
                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${resource.lastUpdated}"/></td> 
                        <td>
                            <a href="ReliefResourceController?resourceId=${resource.resourceId}&action=view">View</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
