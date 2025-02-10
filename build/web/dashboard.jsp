<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-12">
                <h2>Welcome, ${user.fullName}!</h2>
                <p>Role: ${user.role}</p>
                <div class="card-deck mt-4">
                    <div class="card bg-primary text-white">
                        <div class="card-body">
                            <h5 class="card-title">Total Disasters</h5>
                            <p class="card-text">${totalDisasters}</p> 
                        </div>
                    </div>
                    <div class="card bg-success text-white">
                        <div class="card-body">
                            <h5 class="card-title">Total Resources</h5>
                            <p class="card-text">${totalResources}</p> 
                        </div>
                    </div>
                    <div class="card bg-info text-white">
                        <div class="card-body">
                            <h5 class="card-title">Pending Requests</h5>
                            <p class="card-text">${totalPendingRequests}</p> 
                        </div>
                    </div>
                    <div class="card bg-warning text-dark">
                        <div class="card-body">
                            <h5 class="card-title">Approved Volunteers</h5>
                            <p class="card-text">${totalApprovedVolunteers}</p> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
