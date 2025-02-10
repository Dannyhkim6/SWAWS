<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
            <%@ include file="headerUser.jsp" %>

    <div class="contact-container">
        <h2>Contact Us</h2>
        <p>Have questions or need assistance? Reach out to us.</p>

        <div class="contact-info">
            <div class="contact-item">
                <img src="Media/em.png" alt="Email Icon">
                <h3>Email</h3>
                <p><a href="mailto:support@swaws.org">support@swaws.org</a></p>
            </div>
            <div class="contact-item">
                <img src="Media/ph.png" alt="Phone Icon">
                <h3>Phone</h3>
                <p>+03 223 1231</p>
            </div>
            <div class="contact-item">
                <img src="Media/loc.png" alt="Location Icon">
                <h3>Location</h3>
                <p>11 Swaws HQ, Shah Alam</p>
            </div>
        </div>

        <h2>Emergency Contacts</h2>
        <div class="contact-list">
            <div class="contact-card">
                <h3>Police</h3>
                <p>Emergency Number:999</p>
            </div>
            <div class="contact-card">
                <h3>Fire Department</h3>
                <p>Emergency Number:999</p>
            </div>
            <div class="contact-card">
                <h3>Ambulance</h3>
                <p>Emergency Number: 999</p>
            </div>
            <div class="contact-card">
                <h3>Flood Relief Center</h3>
                <p>Hotline:90800-123-456</p>
            </div>
            <div class="contact-card">
                <h3>Disaster Relief Coordination Center</h3>
                <p>Hotline: 1800-112-233</p>
                <p>Email: <a href="mailto:relief@disasterswaws.org">relief@disaster.org</a></p>
            </div>
        </div>
    </div>

            <%@ include file="footer.jsp" %>
</body>
</html>
