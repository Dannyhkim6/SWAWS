package com.relief.controller;

import com.relief.dao.RequestDAO;
import com.relief.dao.ReliefResourceDAO;
import com.relief.dao.LocationDAO;
import com.relief.model.Request;
import com.relief.model.ReliefResource;
import com.relief.model.Location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class RequestUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
        List<ReliefResource> resources = resourceDAO.getAllReliefResources();
        request.setAttribute("resources", resources);

        LocationDAO locationDAO = new LocationDAO();
        List<Location> locations = locationDAO.getAllLocations();
        request.setAttribute("locations", locations);

        if (action != null && action.equals("view")) {
            int requestId = Integer.parseInt(request.getParameter("requestId"));
            RequestDAO requestDAO = new RequestDAO();
            Request req = requestDAO.getRequestById(requestId);
            request.setAttribute("selectedRequest", req);
            request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
        } else {
            RequestDAO requestDAO = new RequestDAO();
            List<Request> requests = requestDAO.getAllRequests();
            request.setAttribute("requests", requests);
            request.getRequestDispatcher("request.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
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
                    response.sendRedirect("RequestUserServlet");
                } else {
                    request.setAttribute("errorMessage", "Failed to add request.");
                    ReliefResourceDAO resDAO = new ReliefResourceDAO();
                    List<ReliefResource> resources = resDAO.getAllReliefResources();
                    request.setAttribute("resources", resources);
                    
                    LocationDAO locDAO = new LocationDAO();
                    List<Location> locations = locDAO.getAllLocations();
                    request.setAttribute("locations", locations);
                    
                    request.getRequestDispatcher("request.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid numeric format for resource ID, location ID or quantity.");
                ReliefResourceDAO resDAO = new ReliefResourceDAO();
                List<ReliefResource> resources = resDAO.getAllReliefResources();
                request.setAttribute("resources", resources);
                    
                LocationDAO locDAO = new LocationDAO();
                List<Location> locations = locDAO.getAllLocations();
                request.setAttribute("locations", locations);
                    
                request.getRequestDispatcher("request.jsp").forward(request, response);
            }
        }
    }
}
