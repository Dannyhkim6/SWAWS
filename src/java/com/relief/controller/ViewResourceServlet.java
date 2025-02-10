package com.relief.controller;

import com.relief.dao.ReliefResourceDAO;
import com.relief.model.ReliefResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewResourceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int resourceId = Integer.parseInt(request.getParameter("resourceId"));
        ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
        ReliefResource resource = resourceDAO.getReliefResourceById(resourceId);
        request.setAttribute("resource", resource);
        request.getRequestDispatcher("viewResource.jsp").forward(request, response);
    }
}