package com.relief.controller;

import com.relief.dao.RequestDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        RequestDAO requestDAO = new RequestDAO();

        if (requestDAO.deleteRequest(requestId)) {
            response.sendRedirect("RequestController");
        } else {
            request.setAttribute("errorMessage", "Failed to delete request.");
            request.getRequestDispatcher("requestManagement.jsp").forward(request, response);
        }
    }
}