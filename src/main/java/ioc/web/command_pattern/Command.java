package ioc.web.command_pattern;

import ioc.exception.OrderNotFoundException;
import ioc.exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Command {

    String execute(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, UserNotFoundException, OrderNotFoundException {
        return null;
    }
}
