package controller;


import model.Event;
import service.FinalServerUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(value = "/server")
public class FinalServerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        LinkedList<Event> eventLinkedList = FinalServerUtil.getEventLinkedList();
        httpServletRequest.setAttribute("eventList", eventLinkedList);

        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("server.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}