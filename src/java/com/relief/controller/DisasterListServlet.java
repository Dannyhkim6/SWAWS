package com.relief.controller;

import com.relief.dao.DisasterDAO;
import com.relief.model.Disaster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisasterListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DisasterDAO disasterDAO = new DisasterDAO();
        List<Disaster> disasters = disasterDAO.getAllDisasters();
        request.setAttribute("disasters", disasters);
        request.getRequestDispatcher("disaster.jsp").forward(request, response);
    }
}