package edu.matc.controller;

import edu.matc.persistence.UserDao;
//import edu.matc.persistence.SpotDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to display a user by ID.
 * @author JeevaG
 */

@WebServlet(
        urlPatterns = {"/searchUserById"}
)

public class SearchUserById extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param req Description of the Parameter
     *@param resp Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // UserData userData = new UserData();
        int id = Integer.parseInt(req.getParameter("param1"));
        UserDao userDao = new UserDao();
        req.setAttribute("user", userDao.getById(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}