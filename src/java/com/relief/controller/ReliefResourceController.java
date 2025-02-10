package com.relief.controller;

import com.relief.dao.ReliefResourceDAO;
import com.relief.model.ReliefResource;
import com.relief.dao.LocationDAO;
import com.relief.model.Location;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ReliefResourceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            int resourceId = Integer.parseInt(request.getParameter("resourceId"));
            ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
            ReliefResource resource = resourceDAO.getReliefResourceById(resourceId);

            LocationDAO locationDAO = new LocationDAO();
            List<Location> locations = locationDAO.getAllLocations();
            request.setAttribute("locations", locations);

            request.setAttribute("resource", resource);
            request.getRequestDispatcher("viewResource.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            int resourceId = Integer.parseInt(request.getParameter("resourceId"));
            ReliefResourceDAO resourceDAO = new ReliefResourceDAO();

            if (resourceDAO.deleteReliefResource(resourceId)) {
                response.sendRedirect("ReliefResourceController");
            } else {
                request.setAttribute("errorMessage", "Failed to delete resource.");
                request.getRequestDispatcher("resourceManagement.jsp").forward(request, response);
            }
        } else {
            ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
            List<ReliefResource> resources = resourceDAO.getAllReliefResources();

            LocationDAO locationDAO = new LocationDAO();
            List<Location> locations = locationDAO.getAllLocations();

            request.setAttribute("resources", resources);
            request.setAttribute("locations", locations);
            request.getRequestDispatcher("resourceManagement.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            String resourceName = request.getParameter("resourceName");
            String resourceType = request.getParameter("resourceType");
            String resourceStatus = request.getParameter("resourceStatus");
            String locationIdStr = request.getParameter("locationId");
            String resourceQtyStr = request.getParameter("resourceQty");

            try {
                int locationId = Integer.parseInt(locationIdStr);
                int resourceQty = Integer.parseInt(resourceQtyStr);

                ReliefResource resource = new ReliefResource(
                        0,
                        resourceName,
                        resourceType,
                        resourceStatus,
                        locationId,
                        resourceQty,
                        new Timestamp(new Date().getTime())
                );

                ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
                if (resourceDAO.addReliefResource(resource)) {
                    response.sendRedirect("ReliefResourceController");
                } else {
                    request.setAttribute("errorMessage", "Failed to add resource.");
                    request.getRequestDispatcher("resourceManagement.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                handleError(request, response, "Invalid location ID or resource quantity format");
            }
        } else if (action != null && action.equals("update")) {
            try {
                int resourceId = Integer.parseInt(request.getParameter("resourceId"));
                String resourceName = request.getParameter("resourceName");
                String resourceType = request.getParameter("resourceType");
                String resourceStatus = request.getParameter("resourceStatus");
                String locationIdStr = request.getParameter("locationId");
                String resourceQtyStr = request.getParameter("resourceQty");

                int locationId = Integer.parseInt(locationIdStr);
                int resourceQty = Integer.parseInt(resourceQtyStr);

                ReliefResource resource = new ReliefResource(
                        resourceId,
                        resourceName,
                        resourceType,
                        resourceStatus,
                        locationId,
                        resourceQty,
                        new Timestamp(new Date().getTime())
                );

                ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
                if (resourceDAO.updateReliefResource(resource)) {
                    response.sendRedirect("ReliefResourceController");
                } else {
                    request.setAttribute("errorMessage", "Failed to update resource.");
                    request.getRequestDispatcher("viewResource.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                handleError(request, response, "Invalid input format for resource update.");
            }
        }
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", message);
        request.getRequestDispatcher("resourceManagement.jsp").forward(request, response);
    }
}
