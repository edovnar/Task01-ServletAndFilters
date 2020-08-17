package ioc.web.command_pattern.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import ioc.domain.Order;
import ioc.service.OrderService;
import ioc.web.command_pattern.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostOrderCommand extends Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderService orderService = context.getBean(OrderService.class);
        Order order = new ObjectMapper().readValue(req.getReader(), Order.class);

        orderService.postOrder(order);
        resp.getWriter().write("Order is accepted");
    }
}
