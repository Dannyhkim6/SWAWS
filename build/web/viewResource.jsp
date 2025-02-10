<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View Resource</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="container mt-4">
            <h2>Resource Details</h2>
            <c:if test="${not empty resource}">
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Resource ID:</th>
                            <td>${resource.resourceId}</td>
                        </tr>
                        <tr>
                            <th>Name:</th>
                            <td>${resource.resourceName}</td>
                        </tr>
                        <tr>
                            <th>Type:</th>
                            <td>${resource.resourceType}</td>
                        </tr>
                        <tr>
                            <th>Status:</th>
                            <td>${resource.resourceStatus}</td>
                        </tr>
                        <tr>
                            <th>Location ID:</th>
                            <td>${resource.locationId}</td>
                        </tr>
                        <tr>
                            <th>Quantity:</th>
                            <td>${resource.resourceQty}</td>
                        </tr>
                        <tr>
                            <th>Last Updated:</th>
                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${resource.lastUpdated}"/></td>
                        </tr>
                    </tbody>
                </table>

                <!-- Update Form -->
                <form action="ReliefResourceController" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="resourceId" value="${resource.resourceId}">
                    <div class="form-group">
                        <label>Resource Name:</label>
                        <input type="text" name="resourceName" class="form-control" value="${resource.resourceName}">
                    </div>
                    <div class="form-group">
                        <label>Type:</label>
                        <select name="resourceType" class="form-control">
                            <option value="Food" ${resource.resourceType == 'Food' ? 'selected' : ''}>Food</option>
                            <option value="Medical" ${resource.resourceType == 'Medical' ? 'selected' : ''}>Medical</option>
                            <option value="Shelter" ${resource.resourceType == 'Shelter' ? 'selected' : ''}>Shelter</option>
                            <option value="Clothing" ${resource.resourceType == 'Clothing' ? 'selected' : ''}>Clothing</option>
                            <option value="etc" ${resource.resourceType == 'etc' ? 'selected' : ''}>etc</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Status:</label>
                        <select name="resourceStatus" class="form-control">
                            <option value="Available" ${resource.resourceStatus == 'Available' ? 'selected' : ''}>Available</option>
                            <option value="Low Stock" ${resource.resourceStatus == 'Low Stock' ? 'selected' : ''}>Low Stock</option>
                            <option value="Out of Stock" ${resource.resourceStatus == 'Out of Stock' ? 'selected' : ''}>Out of Stock</option>
                        </select>
                    </div>
                    <!-- For editing location, you may also use a drop-down similar to resourceManagement.jsp -->
                    <div class="form-group">
                        <label>Location:</label>
                        <select name="locationId" class="form-control" required>
                            <c:forEach items="${locations}" var="loc">
                                <option value="${loc.locationID}" ${loc.locationID == resource.locationId ? 'selected' : ''}>
                                    ${loc.locationID} - ${loc.reliefCenter}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Quantity:</label>
                        <input type="number" name="resourceQty" class="form-control" value="${resource.resourceQty}">
                    </div>
                    <button type="submit" class="btn btn-primary">Update</button>
                </form>

                <!-- Delete Button -->
                <button type="button" class="btn btn-danger mt-3" onclick="confirmDelete(${resource.resourceId})">Delete</button>

            </c:if>

            <c:if test="${empty resource}">
                <p>No resource found.</p>
            </c:if>

            <a href="ReliefResourceController" class="btn btn-secondary mt-3">Back to Resource List</a>
        </div>

        <script>
            function confirmDelete(resourceId) {
                Swal.fire({
                    title: 'Are you sure?',
                    text: "This action cannot be undone!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#d33',
                    cancelButtonColor: '#3085d6',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        window.location.href = "ReliefResourceController?resourceId=" + resourceId + "&action=delete";
                    }
                });
            }
        </script>

        <%@ include file="footer.jsp" %>
    </body>
</html>
