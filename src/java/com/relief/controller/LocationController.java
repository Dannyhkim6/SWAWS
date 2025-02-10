package com.relief.controller;

import com.relief.dao.LocationDAO;
import com.relief.model.Location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LocationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            int locationID = Integer.parseInt(request.getParameter("locationID"));
            LocationDAO locationDAO = new LocationDAO();
            Location location = locationDAO.getLocationById(locationID);
            request.setAttribute("location", location);
            request.getRequestDispatcher("viewLocation.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            int locationID = Integer.parseInt(request.getParameter("locationID"));
            LocationDAO locationDAO = new LocationDAO();

            if (locationDAO.deleteLocation(locationID)) {
                response.sendRedirect("LocationController");
            } else {
                request.setAttribute("errorMessage", "Failed to delete location.");
                request.getRequestDispatcher("locationManagement.jsp").forward(request, response);
            }
        } else {
            LocationDAO locationDAO = new LocationDAO();
            List<Location> locations = locationDAO.getAllLocations();
            request.setAttribute("locations", locations);
            request.getRequestDispatcher("locationManagement.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            String locationName = request.getParameter("locationName");
            String coordinate = request.getParameter("coordinate");
            int population = Integer.parseInt(request.getParameter("population"));
            String reliefCenter = request.getParameter("reliefCenter");

            Location location = new Location(0, locationName, coordinate, population, reliefCenter);
            LocationDAO locationDAO = new LocationDAO();

            if (locationDAO.addLocation(location)) {
                response.sendRedirect("LocationController"); // Redirect to refresh the list
            } else {
                request.setAttribute("errorMessage", "Failed to add location.");
                request.getRequestDispatcher("locationManagement.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("update")) {
            int locationID = Integer.parseInt(request.getParameter("locationID"));
            String locationName = request.getParameter("locationName");
            String coordinate = request.getParameter("coordinate");
            int population = Integer.parseInt(request.getParameter("population"));
            String reliefCenter = request.getParameter("reliefCenter");

            Location location = new Location(locationID, locationName, coordinate, population, reliefCenter);
            LocationDAO locationDAO = new LocationDAO();

            if (locationDAO.updateLocation(location)) {
                response.sendRedirect("LocationController");
            } else {
                request.setAttribute("errorMessage", "Failed to update location.");
                request.getRequestDispatcher("viewLocation.jsp").forward(request, response); 
            }
        } 

    }
}