package web;

import exception.CommandNotFoundException;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import web.command_pattern.CommandDistributor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            CommandDistributor.getInstance().getCommand(req.getPathInfo(), req.getMethod()).execute(req, resp);
        } catch (OrderNotFoundException | CommandNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            CommandDistributor.getInstance().getCommand(req.getPathInfo(), req.getMethod()).execute(req, resp);
        } catch (OrderNotFoundException | CommandNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
