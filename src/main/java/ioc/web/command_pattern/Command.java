package ioc.web.command_pattern;

import ioc.exception.OrderNotFoundException;
import ioc.exception.UserNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Command {

    protected ApplicationContext context = new AnnotationConfigApplicationContext("resources/config.xml");

    public void execute(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, UserNotFoundException, OrderNotFoundException {

    }
}
