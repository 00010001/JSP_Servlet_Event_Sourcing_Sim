package controller;


import model.Event;
import service.QueueServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/queue")
public class QueueController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        LinkedList<Event> eventLinkedList = QueueServer.getEventLinkedList();
        httpServletRequest.setAttribute("eventList", eventLinkedList);

        List<String> serversURLList = QueueServer.getServersURLList();
        httpServletRequest.setAttribute("serverURLs", serversURLList);

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("queue.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
