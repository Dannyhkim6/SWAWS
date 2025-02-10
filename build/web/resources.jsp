<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resources</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
        <%@ include file="headerUser.jsp" %>
    
    <div class="resources-container">
        <section class="resources-intro">
            <h2>Resources</h2>
            <p>Browse through information that aid in disaster preparedness and relief efforts.</p>
        </section>

    <section id="incidents" class="section-disaster">
       
        <h2>Resource List</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Resource ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Location ID</th>
                    <th>Quantity</th>
                    <th>Last Updated</th>
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </section>
    </div>
        <%@ include file="footer.jsp" %>

</body>
</html>
