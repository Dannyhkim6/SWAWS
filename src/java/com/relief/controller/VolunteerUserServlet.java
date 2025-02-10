package com.relief.controller;

import com.relief.dao.VolunteerDAO;
import com.relief.model.Volunteer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class VolunteerUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        VolunteerDAO volunteerDAO = new VolunteerDAO();
        List<Volunteer> volunteers = volunteerDAO.getAllVolunteers();
        request.setAttribute("volunteers", volunteers); 

        request.getRequestDispatcher("joinUs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String nric = request.getParameter("nric");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String gender = request.getParameter("gender");
        String areaOfInterest = request.getParameter("areaOfInterest");
        String reason = request.getParameter("reason");
        String status = "Pending"; 

        Volunteer volunteer = new Volunteer(0, name, nric, email, phoneNum, areaOfInterest, reason, status, gender); 
        VolunteerDAO volunteerDAO = new VolunteerDAO();
        boolean success = volunteerDAO.addVolunteer(volunteer);

        if (success) {
            response.sendRedirect("VolunteerUserServlet");
        } else {
            request.setAttribute("errorMessage", "Failed to register volunteer.");
            request.getRequestDispatcher("joinUs.jsp").forward(request, response);
        }
    }
}