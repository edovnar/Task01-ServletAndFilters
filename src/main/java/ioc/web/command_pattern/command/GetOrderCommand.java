package ioc.web.command_pattern.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import ioc.service.OrderService;
import ioc.utils.AppContext;
import ioc.utils.JsonUtil;
import ioc.web.command_pattern.Command;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GetOrderCommand extends Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        OrderService orderService = AppContext.getContext().getBean(OrderService.class);
        resp.setContentType("application/json");
        ObjectMapper objectMapper = AppContext.getContext().getBean(JsonUtil.class).getObjectMapper();
        resp.getWriter().write(objectMapper.writeValueAsString(orderService.getOrdersFromCurrentUser()));
    }
}
