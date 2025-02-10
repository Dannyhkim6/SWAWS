package com.relief.controller;

import com.relief.dao.VolunteerDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteVolunteerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int volunteerID = Integer.parseInt(request.getParameter("volunteerID"));
        VolunteerDAO volunteerDAO = new VolunteerDAO();

        if (volunteerDAO.deleteVolunteer(volunteerID)) {
            response.sendRedirect("VolunteerController"); 
        } else {
            request.setAttribute("errorMessage", "Failed to delete volunteer.");
            request.getRequestDispatcher("volunteerPage.jsp").forward(request, response);
        }
    }
}