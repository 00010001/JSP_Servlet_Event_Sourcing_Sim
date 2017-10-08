package controller;

import model.Event;
import service.QueueServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queueReceiver")
public class QueueReceiveEvent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String amount = request.getParameter("amount");
        String date = request.getParameter("date");

        Event event = new Event();
        event.setType(type);
        event.setAmount(amount);
        event.setDate(date);

        QueueServer.addEventToQueue(event);
    }


}

