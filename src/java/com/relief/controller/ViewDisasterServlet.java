package com.relief.controller;

import com.relief.dao.DisasterDAO;
import com.relief.dao.LocationDAO;
import com.relief.model.Disaster;
import com.relief.model.Location;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDisasterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int disasterID = Integer.parseInt(request.getParameter("disasterID"));
       
        DisasterDAO disasterDAO = new DisasterDAO();
        Disaster disaster = disasterDAO.getDisasterById(disasterID);

        LocationDAO locationDAO = new LocationDAO();
        List<Location> locations = locationDAO.getAllLocations();
        request.setAttribute("locations", locations);
        request.setAttribute("disaster", disaster);
        request.getRequestDispatcher("viewDisaster.jsp").forward(request, response);
    }
}
