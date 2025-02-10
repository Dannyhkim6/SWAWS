<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Disaster Relief Coordination System</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
        <%@ include file="headerUser.jsp" %>

    <div class="hero" style="background-image: url('Media/banjir1.jpg');">
        <div class="overlay"></div>
        <div class="hero-content">
            <h1>Disasters Response Coordination System</h1>
            <h2>Aiding <span class="highlight">Disaster Response</span> To The Citizens Of Malaysia In Need</h2>
        </div>
    </div>

    <div class="what-we-do">
        <div class="container">
            <div class="what-we-do-content">
                <h2>What We Do</h2>
                <p>We provide disaster response organizations with critical data, science, and technology to improve preparedness, response, and recovery efforts. Our services include satellite imagery analysis, disaster mapping, and advanced tools to support decision-making during critical times.</p>
            </div>
            <div class="disaster-images">
                <img src="Media/budak.jfif" alt="Disaster 1" class="disaster-image">
            </div>
        </div>
    </div>

    <div class="what-we-do" style="margin-top: 60px;">
        <div class="container">
            <div class="disaster-images">
                <img src="Media/volunteer.jpg" alt="Disaster 1" class="disaster-image">
            </div>
            <div class="what-we-do-content">
                <h2>ABOUT US</h2>
                <p>We provide disaster response organizations with critical data, science, and technology to improve preparedness, response, and recovery efforts. Our services include satellite imagery analysis, disaster mapping, and advanced tools to support decision-making during critical times.</p>
                <a href="aboutUs.jsp"><button class="aboutus">Click for more</button></a>
            </div>
        </div>
    </div>

    <div class="join-us">
        <div class="join-us-content">
            <h2>Join Us</h2>
            <p>Become a part of a global effort to improve disaster response and save lives. With your help, we can create a safer future for everyone.</p>
            <div class="buttons-container">
                <a href="VolunteerUserServlet" class="join-button">Get Involved</a>
                <a href="donate.html" class="donate-button">
                    <img src="Media/donation.png" alt="Donate Icon" class="button-icon"> Donate
                </a>
            </div>
        </div>
    </div>
    <footer>
        <p>© 2024 Disaster Relief Coordination System</p>
    </footer>
    <script src="script.js"></script>
</body>
</html>
