package com.relief.controller;

import com.relief.dao.DisasterDAO;
import com.relief.dao.ReliefResourceDAO;
import com.relief.dao.RequestDAO;
import com.relief.dao.VolunteerDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DisasterDAO disasterDAO = new DisasterDAO();
        ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
        RequestDAO requestDAO = new RequestDAO();
        VolunteerDAO volunteerDAO = new VolunteerDAO();

        int totalDisasters = disasterDAO.getTotalDisasters();       
        int totalResources = resourceDAO.getTotalResources();          
        int totalPendingRequests = requestDAO.getTotalPendingRequests(); 
        int totalApprovedVolunteers = volunteerDAO.getTotalApprovedVolunteers();

        request.setAttribute("totalDisasters", totalDisasters);
        request.setAttribute("totalResources", totalResources);
        request.setAttribute("totalPendingRequests", totalPendingRequests);
        request.setAttribute("totalApprovedVolunteers", totalApprovedVolunteers);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
