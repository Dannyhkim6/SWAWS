<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <link rel="stylesheet" href="CSS/style.css">
<!--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">-->
</head>
<body>
        <%@ include file="headerUser.jsp" %>

    <div class="back-button">
        <a href="index.html"><button class="aboutus">Back</button></a>
    </div>    
    <section class="about-us">
        <h1>About Us</h1>
        <p>Welcome to the <strong>Disaster Relief Coordination System</strong>, a web platform dedicated to managing and coordinating disaster relief efforts effectively. Our mission is to streamline disaster response operations, ensuring that aid reaches those in need swiftly and efficiently.</p>
        <div class="container">
            <div class="content">
                <h2>Our Purpose</h2>
                <p>We aim to provide a centralized platform to:</p>
                <ul>
                    <li>Track and monitor disaster incidents such as earthquakes, floods, and wildfires.</li>
                    <li>Manage relief resources including food, medical supplies, and shelters.</li>
                    <li>Process aid requests from affected individuals and organizations.</li>
                    <li>Coordinate volunteers and donations to maximize impact.</li>
                    <li>Deliver real-time updates on disaster situations and resource availability.</li>
                </ul>
            </div>
            <div class="content">
                <h2>What We Offer</h2>
                <p>Our system integrates multiple features to ensure efficient disaster management:</p>
                <ul>
                    <li><strong>Incident Management:</strong> Reporting and tracking disasters with live updates.</li>
                    <li><strong>Resource Allocation:</strong> Managing and distributing relief supplies where they are needed most.</li>
                    <li><strong>Request Processing:</strong> Helping victims and organizations request aid and get quick approvals.</li>
                    <li><strong>Volunteer & Donor Coordination:</strong> Connecting volunteers with relief operations and ensuring transparency in donations.</li>
                    <li><strong>Real-Time Alerts:</strong> Sending emergency notifications and updates to affected communities.</li>
                </ul>
            </div>
            <div class="content">
                <h2>Our Technology</h2>
                <p>The Disaster Relief Coordination System is built on a robust architecture to handle crisis management effectively:</p>
                <ul>
                    <li>Database-driven system for storing incidents, resources, and user data.</li>
                    <li>Secure authentication and role-based access control.</li>
                    <li>Interactive dashboards for monitoring relief efforts.</li>
                    <li>Google Maps API integration for location tracking.</li>
                    <li>Mobile-friendly design for accessibility on any device.</li>
                </ul>
            </div>
            <div class="content">
                <h2>Get Involved</h2>
                <p>We believe that disaster response is a collective effort. You can contribute by:</p>
                <ul>
                    <li><strong>Volunteering:</strong> Assist in logistics, aid distribution, and support operations.</li>
                    <li><strong>Donating:</strong> Provide funds or essential supplies to help those affected.</li>
                    <li><strong>Spreading Awareness:</strong> Share our platform with others to increase impact.</li>
                </ul>
            </div>
        </div>
    </section>
    <section class="developer-credit">
        <div class="container">
            <h2>Meet Our Development Team</h2>
            <div class="team">
                <div class="team-member">
                    <img src="Media/izzat.jpg" alt="Team Member 1">
                    <h3>Izzat Mahfuz</h3>
                    <p>Lead Developer - Backend</p>
                </div>
                <div class="team-member">
                    <img src="Media/solah.png" alt="Team Member 2">
                    <h3>Solahuddin Al-Ayubi</h3>
                    <p>Frontend Developer</p>
                </div>
                <div class="team-member">
                    <img src="Media/arshad.png" alt="Team Member 3">
                    <h3>Arshad</h3>
                    <p>UI/UX Designer</p>
                </div>
                <div class="team-member">
                    <img src="Media/danny.jpg" alt="Team Member 4">
                    <h3>Danial Hakim</h3>
                    <p>Project Manager</p>
                </div>
            </div>
        </div>
    </section>

    <footer>
        <p>© 2024 Disaster Relief Coordination System</p>
    </footer>
</body>
</html>
