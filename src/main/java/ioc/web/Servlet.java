package ioc.web;

import ioc.exception.CommandNotFoundException;
import ioc.exception.OrderNotFoundException;
import ioc.web.command_pattern.CommandDistributor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        ApplicationContext context = new AnnotationConfigApplicationContext("ioc");
        try {
            context.getBean(CommandDistributor.class)
                    .getCommand(request.getPathInfo(), request.getMethod())
                    .execute(request, response);
        } catch (OrderNotFoundException | CommandNotFoundException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
