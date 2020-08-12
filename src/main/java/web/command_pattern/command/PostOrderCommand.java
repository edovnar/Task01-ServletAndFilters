package web.command_pattern.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;
import exception.UserNotFoundException;
import service.OrderService;
import web.command_pattern.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostOrderCommand implements Command {

    private PostOrderCommand(){}

    private static class Singleton{
        private static final PostOrderCommand INSTANCE = new PostOrderCommand();
    }

    public static PostOrderCommand getInstance(){
        return PostOrderCommand.Singleton.INSTANCE;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        OrderService orderService = OrderService.getInstance();
            try {
                Order order = new ObjectMapper().readValue(req.getReader(), Order.class);
                orderService.postOrder(order);
                resp.getWriter().write("Order is accepted");
            } catch (IOException | UserNotFoundException e) {
                e.printStackTrace();
            }
    }
}
