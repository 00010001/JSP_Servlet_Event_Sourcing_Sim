package controller;


import service.FinalServerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getAllEvents")

public class FinalServerGetAllEvents extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FinalServerUtil.getAllEventsFromQueue(FinalServerUtil.getNumberOfEventsInQueue());
        resp.sendRedirect("/server");
    }

}


