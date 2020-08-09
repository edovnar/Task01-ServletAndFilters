package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostCommand extends Command {

    public PostCommand(HttpServletResponse resp,
                       HttpServletRequest req) {
        super(resp, req);
    }

    @Override
    public void execute() {
        if (req.getPathInfo().equals("/orders")){
            try {
                Order order = new ObjectMapper().readValue(req.getReader(), Order.class);

                OrderService.postOrder(order);
                resp.getWriter().write(OrderService.getOrdersByCurrentUser().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
