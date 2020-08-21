package ioc.web.command_pattern.command;

import ioc.service.OrderService;
import ioc.utils.AppContext;
import ioc.web.command_pattern.Command;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GetOrderCommand extends Command {

    public Set execute() {
        OrderService orderService = AppContext.getContext().getBean(OrderService.class);
        return orderService.getOrdersFromCurrentUser();
    }
}
