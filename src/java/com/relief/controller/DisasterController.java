package com.relief.controller;

import com.relief.dao.DisasterDAO;
import com.relief.dao.LocationDAO;
import com.relief.model.Disaster;
import com.relief.model.Location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class DisasterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        DisasterDAO disasterDAO = new DisasterDAO();
        List<Disaster> disasters = disasterDAO.getAllDisasters();

        LocationDAO locationDAO = new LocationDAO();
        List<Location> locations = locationDAO.getAllLocations(); 

        request.setAttribute("disasters", disasters);
        request.setAttribute("locations", locations); 
        request.getRequestDispatcher("disasterManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String disasterName = request.getParameter("disasterName");
        String disasterType = request.getParameter("disasterType");
        int disasterLoc = Integer.parseInt(request.getParameter("disasterLoc")); 
        String description = request.getParameter("description");
        String severity = request.getParameter("severity");

        // Get current date and time
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String disasterDate = formatter.format(date); 

        Disaster disaster = new Disaster(0, disasterName, disasterType, disasterLoc, disasterDate, description, severity);
        DisasterDAO disasterDAO = new DisasterDAO();
        boolean success = disasterDAO.addDisaster(disaster);

        if (success) {
            response.sendRedirect("DisasterController"); // Redirect to the same URL to refresh the list
        } else {
            request.setAttribute("errorMessage", "Failed to add disaster.");
            request.getRequestDispatcher("disasterManagement.jsp").forward(request, response);
        }
    }
} 