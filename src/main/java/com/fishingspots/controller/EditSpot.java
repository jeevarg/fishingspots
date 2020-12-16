package com.fishingspots.controller;

import com.fishingspots.entity.Spot;
import com.fishingspots.entity.User;
import com.fishingspots.persistence.SpotDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Edit spot.
 */
@WebServlet(
        urlPatterns = {"/editSpot"}
)
public class EditSpot extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //rData userData = new UserData();
        SpotDao spotDao = new SpotDao();

        if (req.getParameter("id").equals("")) {
            spotDao.insert(buildSpot(req));
            //userData.insert(user);
        } else {
            spotDao.saveOrUpdate(buildSpot(req));
            //userData.update(user);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/spots.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Build spot spot.
     *
     * @param req the req
     * @return the spot
     */
    public Spot buildSpot(HttpServletRequest req){
        User user = new User(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("email"), req.getParameter("password"));
        Spot spot = new Spot(req.getParameter("spotName"),
                req.getParameter("city"),
                req.getParameter("state"),
                req.getParameter("zipCode"),
                Double.parseDouble(req.getParameter("lat")),
                Double.parseDouble(req.getParameter("lon")),
                user);
        return spot;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //UserData userData = new UserData();
        SpotDao spotDao = new SpotDao();
        req.setAttribute("spot", spotDao.getById(Integer.parseInt(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editSpot.jsp");
        dispatcher.forward(req, resp);
    }
}
