package com.relief.controller;

import com.relief.dao.VolunteerDAO;
import com.relief.model.Volunteer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditVolunteerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int volunteerID = Integer.parseInt(request.getParameter("volunteerID"));
        VolunteerDAO volunteerDAO = new VolunteerDAO();
        Volunteer volunteer = volunteerDAO.getVolunteerById(volunteerID);

        request.setAttribute("volunteer", volunteer);
        request.getRequestDispatcher("editVolunteer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int volunteerID = Integer.parseInt(request.getParameter("volunteerID"));
        String status = request.getParameter("status"); 

        VolunteerDAO volunteerDAO = new VolunteerDAO();
        Volunteer volunteer = volunteerDAO.getVolunteerById(volunteerID);

        volunteer.setStatus(status); 

        if (volunteerDAO.updateVolunteerStatus(volunteer)) {
            response.sendRedirect("VolunteerController"); 
        } else {
            request.setAttribute("errorMessage", "Failed to update volunteer status.");
            request.getRequestDispatcher("editVolunteer.jsp").forward(request, response);
        }
    }
}