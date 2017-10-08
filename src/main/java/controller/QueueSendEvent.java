package controller;

import org.json.JSONObject;
import service.QueueServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queueSendEvent")
public class QueueSendEvent extends HttpServlet {
    //http://www.developer.com/design/article.php/10925_3597071_3/Serializing-an-Object-via-a-ClientServer-Connection.htm

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        JSONObject json = QueueServer.getFirstEventAsJsonObjectAndRemoveItAfter();
        out.print(json.toString());

    }
}
