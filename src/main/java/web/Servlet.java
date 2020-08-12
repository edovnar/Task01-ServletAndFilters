package web;

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
        } catch (UserNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } catch (OrderNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            CommandDistributor.getInstance().getCommand(req.getPathInfo(), req.getMethod()).execute(req, resp);
        } catch (UserNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } catch (OrderNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
