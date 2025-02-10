package com.relief.controller;

import com.relief.dao.ReliefResourceDAO;
import com.relief.model.ReliefResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ResourceUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("view")) {
            int resourceId = Integer.parseInt(request.getParameter("resourceId"));
            ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
            ReliefResource resource = resourceDAO.getReliefResourceById(resourceId);
            request.setAttribute("resource", resource);
            request.getRequestDispatcher("viewResource.jsp").forward(request, response);
        }else {
            ReliefResourceDAO resourceDAO = new ReliefResourceDAO();
            List<ReliefResource> resources = resourceDAO.getAllReliefResources();
            request.setAttribute("resources", resources);
            request.getRequestDispatcher("resources.jsp").forward(request, response);
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
                    response.sendRedirect("ResourceUserServlet");
                } else {
                    request.setAttribute("errorMessage", "Failed to add resource.");
                    request.getRequestDispatcher("resources.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                handleError(request, response, "Invalid location ID or resource quantity format");
            }
        }
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", message);
        request.getRequestDispatcher("resources.jsp").forward(request, response);
    }
}
