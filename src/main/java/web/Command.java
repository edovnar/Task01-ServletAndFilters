package web;

import exception.OrderNotFoundException;
import exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Command {

    protected HttpServletResponse resp;
    protected HttpServletRequest req;

    public Command(HttpServletResponse resp,
                   HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public abstract void execute() throws IOException, UserNotFoundException, OrderNotFoundException;
}
