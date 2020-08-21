package ioc.web.command_pattern.command;

import ioc.domain.Order;
import ioc.service.OrderService;
import ioc.utils.AppContext;
import ioc.web.command_pattern.Command;
import org.springframework.stereotype.Component;

@Component
public class PostOrderCommand extends Command {

    public String execute(Order order){

        OrderService orderService = AppContext.getContext().getBean(OrderService.class);
        orderService.postOrder(order);
        return "Order is accepted";
    }
}
