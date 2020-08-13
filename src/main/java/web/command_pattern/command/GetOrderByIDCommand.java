package web.command_pattern.command;

import service.OrderService;
import utils.JsonUtil;
import web.command_pattern.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrderByIDCommand implements Command {

    private GetOrderByIDCommand() { }

    private static class Singleton {
        private static final GetOrderByIDCommand INSTANCE = new GetOrderByIDCommand();
    }

    public static GetOrderByIDCommand getInstance() {
        return Singleton.INSTANCE;
    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderService orderService = OrderService.getInstance();
        String id = req.getPathInfo().split("/")[2];

        resp.setContentType("application/json");
        resp.getWriter().write(JsonUtil.objectMapper.writeValueAsString(orderService.getOrderByIdFromCurrentUser(id)));
    }
}
