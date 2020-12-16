package com.fishingspots.controller;

import com.fishingspots.entity.Role;
import com.fishingspots.entity.User;
import com.fishingspots.persistence.GenericDao;
import com.fishingspots.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Register user.
 */
@WebServlet(
        urlPatterns = {"/registerUser"}
)
public class RegisterUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GenericDao genericDao = new GenericDao();
        //UserDao userDao = new UserDao();
        User user = new User();
        GenericDao genericDao = new GenericDao(User.class);
        user.setId(0);
        user.setFirstName(req.getParameter("paramFirstName"));
        user.setLastName(req.getParameter("paramLastName"));

        user.setEmail(req.getParameter("paramEmailID"));
        user.setPassword(req.getParameter("paramPassword"));
        int id = genericDao.insert(user);
        if(id != 0) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registerSuccess.jsp");
            dispatcher.forward(req, resp);
        }
    }
}