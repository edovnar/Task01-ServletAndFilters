package web.command_pattern.command;

import exception.UserNotFoundException;
import service.OrderService;
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
    public void execute(HttpServletRequest req, HttpServletResponse resp){
        OrderService orderService = OrderService.getInstance();
        try {
            resp.getWriter().write(orderService.getOrdersFromCurrentUser().toString());
        } catch (IOException | UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
