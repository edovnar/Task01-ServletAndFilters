package web;

import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCommand extends Command {
    public GetCommand(HttpServletResponse resp,
                      HttpServletRequest req) {
        super(resp, req);
    }

    @Override
    public void execute() {
        if (req.getContextPath().equals("/orders")) {
            try {
                resp.getWriter().write(OrderService.getOrdersByCurrentUser().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                resp.getWriter().write("let's try again");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
