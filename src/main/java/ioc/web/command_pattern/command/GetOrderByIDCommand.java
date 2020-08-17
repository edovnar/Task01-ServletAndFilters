package ioc.web.command_pattern.command;

import ioc.service.OrderService;
import ioc.utils.AppContext;
import ioc.utils.JsonUtil;
import ioc.web.command_pattern.Command;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GetOrderByIDCommand extends Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        OrderService orderService = AppContext.getContext().getBean(OrderService.class);
        String id = req.getPathInfo().split("/")[2];

        resp.setContentType("application/json");
        resp.getWriter().write(JsonUtil.OBJECT_MAPPER.writeValueAsString(orderService.getOrderByIdFromCurrentUser(id)));
    }
}
