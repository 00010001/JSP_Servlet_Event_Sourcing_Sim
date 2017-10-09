package controller;

import config.ServerConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/serverUpdateSettings")
public class FinalServerUpdateSettings extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String onNotify = req.getParameter("onNotify");
        ServerConfig.onNotifyFetchAllEvents = !onNotify.equals("single");
        resp.sendRedirect("/server");
    }
}
