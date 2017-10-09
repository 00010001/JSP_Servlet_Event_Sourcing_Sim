package controller;

import service.QueueServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//https://stackoverflow.com/questions/4205980/java-sending-http-parameters-via-post-method-easily

@WebServlet(
        value = "/queueAddServerURL"
)
public class QueueAddServer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getParameter("serverURL");
        if(url.length() == 0){
            System.out.println("invalid url, cant add");
        } else {
            System.out.println("added: " + url);
            QueueServer.addServerURL(url);
        }


        resp.sendRedirect("/queue");
    }
}