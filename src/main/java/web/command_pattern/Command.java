package web.command_pattern;

import exception.OrderNotFoundException;
import exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    void execute(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, UserNotFoundException, OrderNotFoundException;
}
