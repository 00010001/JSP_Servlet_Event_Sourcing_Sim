package controller;

import service.HttpPostUtil;
import service.QueueServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queueNotifyAll")
public class QueueNotifyAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(QueueServer.getNumberOfEventsInQueue() == 0){
            System.out.println("Queue is empty, so cant notify");
        } else {
            System.out.println("notifying all");

            System.out.println("server list size = " + QueueServer.getServersURLList().size());

            for (String url : QueueServer.getServersURLList()) {

                int httpCode = HttpPostUtil.SendNumberOfEventsInQueue(url);
                System.out.println("code:" + httpCode);
            }
        }

        resp.sendRedirect("/queue");
    }
}