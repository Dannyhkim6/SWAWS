package com.relief.controller;

import com.relief.dao.LocationDAO;
import com.relief.model.Location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LocationListServlet extends HttpServlet {

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
        } else {
            LocationDAO locationDAO = new LocationDAO();
            List<Location> locations = locationDAO.getAllLocations();
            request.setAttribute("locations", locations);
            request.getRequestDispatcher("location.jsp").forward(request, response);
        }
    }
}