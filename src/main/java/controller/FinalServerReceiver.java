package controller;

import service.FinalServerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/finalServerReceiver")
public class FinalServerReceiver extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String eventsInQueue = request.getParameter("eventsInQueue");

        FinalServerUtil.getEventFromQueueServer();

    }

}
