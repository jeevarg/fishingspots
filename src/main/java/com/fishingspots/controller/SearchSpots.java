package com.fishingspots.controller;

import com.fishingspots.persistence.UserDao;
import com.fishingspots.persistence.ZipCodeAPIDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A simple servlet to display spots.
 * @author JeevaG
 */

@WebServlet(
        urlPatterns = {"/searchSpots"}
)

public class SearchSpots extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param req Description of the Parameter
     *@param resp Description of the Parameter
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // UserData userData = new UserData();
        int zipCode = Integer.parseInt(req.getParameter("param1"));
        int miles = Integer.parseInt(req.getParameter("param2"));

        //UserDao userDao = new UserDao();
        ZipCodeAPIDao dao = new ZipCodeAPIDao();
        req.setAttribute("spots", dao.getZipCodesByRadius(zipCode,miles));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/spots.jsp");
        dispatcher.forward(req, resp);
    }
}
