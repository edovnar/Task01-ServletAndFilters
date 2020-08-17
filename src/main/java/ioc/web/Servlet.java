package ioc.web;

import ioc.exception.CommandNotFoundException;
import ioc.exception.OrderNotFoundException;
import ioc.utils.AppContext;
import ioc.web.command_pattern.CommandDistributor;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class Servlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        try {
            AppContext.getContext().getBean(CommandDistributor.class)
                    .getCommand(request.getPathInfo(), request.getMethod())
                    .execute(request, response);
        } catch (OrderNotFoundException | CommandNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
