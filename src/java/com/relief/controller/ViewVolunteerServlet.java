package com.relief.controller;

import com.relief.dao.VolunteerDAO;
import com.relief.model.Volunteer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewVolunteerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int volunteerID = Integer.parseInt(request.getParameter("volunteerID"));
        VolunteerDAO volunteerDAO = new VolunteerDAO();
        Volunteer volunteer = volunteerDAO.getVolunteerById(volunteerID);

        request.setAttribute("volunteer", volunteer);
        request.getRequestDispatcher("viewVolunteer.jsp").forward(request, response);
    }
}