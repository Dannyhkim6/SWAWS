package com.relief.controller;

import com.relief.dao.RequestDAO;
import com.relief.model.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String requestStatus = request.getParameter("requestStatus");

        RequestDAO requestDAO = new RequestDAO();
        Request rq = requestDAO.getRequestById(requestId); 
        rq.setRequestStatus(requestStatus); 

        if (requestDAO.updateRequestStatus(rq)) { 
            response.sendRedirect("RequestController"); 
        } else {
            request.setAttribute("errorMessage", "Failed to update request status.");
            request.getRequestDispatcher("viewRequest.jsp").forward(request, response); 
        }
    }
}