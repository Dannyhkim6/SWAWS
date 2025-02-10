package com.relief.controller;

import com.relief.dao.DisasterDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDisasterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int disasterID = Integer.parseInt(request.getParameter("disasterID"));
        DisasterDAO disasterDAO = new DisasterDAO();

        if (disasterDAO.deleteDisaster(disasterID)) {
            response.sendRedirect("DisasterController"); 
        } else {
            request.setAttribute("errorMessage", "Failed to delete disaster.");
            request.getRequestDispatcher("disasterManagement.jsp").forward(request, response);
        }
    }
}