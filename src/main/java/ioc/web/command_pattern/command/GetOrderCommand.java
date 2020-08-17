package ioc.web.command_pattern.command;

import ioc.service.OrderService;
import ioc.utils.JsonUtil;
import ioc.web.command_pattern.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrderCommand extends Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        OrderService orderService = context.getBean(OrderService.class);
        resp.setContentType("application/json");
        resp.getWriter().write(JsonUtil.OBJECT_MAPPER.writeValueAsString(orderService.getOrdersFromCurrentUser()));
    }
}
