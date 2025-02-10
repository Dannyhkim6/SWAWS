<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>An error occurred.</h1>
    <p>${errorMessage}</p> 

    <% if (request.getAttribute("exception") != null) { %>
        <h3>Exception Details:</h3>
        <pre>${exception}</pre> 
    <% } %>

    <a href="index.jsp">Return to Home</a> 
</body>
</html>