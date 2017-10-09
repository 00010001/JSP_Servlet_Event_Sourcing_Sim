package controller;

import config.ServerConfig;
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

        System.out.println("Current Config fetchAll: " + ServerConfig.onNotifyFetchAllEvents);
        String eventsInQueue = request.getParameter("eventsInQueue");
        int numberOfEventsInQueue = Integer.parseInt(eventsInQueue);
        if(ServerConfig.onNotifyFetchAllEvents && numberOfEventsInQueue > 1){
            System.out.println("getting all");
            FinalServerUtil.getAllEventsFromQueue(numberOfEventsInQueue);
        } else {
            System.out.println("getting single");
            FinalServerUtil.getEventFromQueueServer();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/server");

    }
}
