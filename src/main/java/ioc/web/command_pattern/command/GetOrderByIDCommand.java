package ioc.web.command_pattern.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import ioc.domain.Order;
import ioc.service.OrderService;
import ioc.utils.AppContext;
import ioc.web.command_pattern.Command;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GetOrderByIDCommand extends Command {

    public Order execute(String id) {

        OrderService orderService = AppContext.getContext().getBean(OrderService.class);
        return orderService.getOrderByIdFromCurrentUser(id);
    }
}
