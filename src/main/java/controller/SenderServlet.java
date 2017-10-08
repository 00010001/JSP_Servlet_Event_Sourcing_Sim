package controller;

import config.URLConfig;
import service.HttpPostUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//https://stackoverflow.com/questions/4205980/java-sending-http-parameters-via-post-method-easily

@WebServlet("/SendEventByHttpPost")
public class SenderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        String amount = req.getParameter("amount");

        int httpCode = HttpPostUtil.SendEventByHttpPost(type,amount, URLConfig.LOCALHOST + "/queueReceiver");

        System.out.println(type + " " + amount + " code:" + httpCode);
        resp.sendRedirect("/");
    }
}