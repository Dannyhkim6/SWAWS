package com.relief.controller;

import com.relief.dao.RequestDAO;
import com.relief.model.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class RequestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            int requestId = Integer.parseInt(request.getParameter("requestId"));
            RequestDAO requestDAO = new RequestDAO();
            Request req = requestDAO.getRequestById(requestId);
            request.setAttribute("selectedRequest", req);
            request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            int requestId = Integer.parseInt(request.getParameter("requestId"));
            RequestDAO requestDAO = new RequestDAO();

            if (requestDAO.deleteRequest(requestId)) {
                response.sendRedirect("RequestController");
            } else {
                request.setAttribute("errorMessage", "Failed to delete request.");
                request.getRequestDispatcher("requestManagement.jsp").forward(request, response);
            }
        } else {
            RequestDAO requestDAO = new RequestDAO();
            List<Request> requests = requestDAO.getAllRequests();
            request.setAttribute("requests", requests);
            request.getRequestDispatcher("requestManagement.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            // Retrieve input values from the form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phonenum = request.getParameter("phonenum");
            String resourceIdStr = request.getParameter("resourceId");
            String locationIdStr = request.getParameter("locationId");
            String requestQtyStr = request.getParameter("requestQty");
            String priority = request.getParameter("priority");

            try {
                int resourceId = Integer.parseInt(resourceIdStr);
                int locationId = Integer.parseInt(locationIdStr);
                int requestQty = Integer.parseInt(requestQtyStr);

               
                Request req = new Request(
                        0,
                        resourceId,
                        requestQty,
                        new Timestamp(new Date().getTime()),
                        "Pending",
                        priority,
                        name,
                        email,
                        phonenum,
                        locationId 
                );

                RequestDAO requestDAO = new RequestDAO();
                if (requestDAO.addRequest(req)) {
                    response.sendRedirect("RequestController");
                } else {
                    request.setAttribute("errorMessage", "Failed to add request.");
                    request.getRequestDispatcher("requestManagement.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid numeric format for resource ID, location ID or quantity.");
                request.getRequestDispatcher("requestManagement.jsp").forward(request, response);
            }
        } else if (action != null && action.equals("update")) {
            try {
                int requestId = Integer.parseInt(request.getParameter("requestId"));
                String newStatus = request.getParameter("requestStatus");

                RequestDAO requestDAO = new RequestDAO();
                Request existingRequest = requestDAO.getRequestById(requestId);

                if (existingRequest != null) {
                    existingRequest.setRequestStatus(newStatus);
                    if (requestDAO.updateRequestStatus(existingRequest)) {
                        response.sendRedirect("RequestController");
                    } else {
                        request.setAttribute("errorMessage", "Failed to update request status.");
                        request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid request ID format.");
                request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
            }
        }
    }
}
