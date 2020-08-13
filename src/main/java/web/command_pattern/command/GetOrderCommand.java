package web.command_pattern.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.OrderService;
import utils.JsonUtil;
import web.command_pattern.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrderCommand implements Command {

   private GetOrderCommand(){}

   private static class Singleton{
       private static final GetOrderCommand INSTANCE = new GetOrderCommand();
   }

   public static GetOrderCommand getInstance(){
       return Singleton.INSTANCE;
   }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        OrderService orderService = OrderService.getInstance();
        resp.setContentType("application/json");
        resp.getWriter().write(JsonUtil.objectMapper.writeValueAsString(orderService.getOrdersFromCurrentUser()));
    }
}
