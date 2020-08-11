package web;

import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCommand extends Command{

    public GetCommand(HttpServletResponse resp, HttpServletRequest req) {
        super(resp, req);
    }

    @Override
    public void execute(){
        String[] path = req.getPathInfo().split("/");
        try {
            if(req.getPathInfo().equals("/orders")){
                    resp.getWriter().write(OrderService.getOrdersFromCurrentUser().toString());
            }
            else if(req.getPathInfo().equals("/orders/" + path[2])){
                String id = req.getPathInfo().split("/")[2];
                resp.getWriter().write(OrderService.getOrderByIdFromCurrentUser(id).toString());
            }
            else
                resp.getWriter().write("let's try again");
        } catch (IOException | UserNotFoundException | OrderNotFoundException e) {
            e.printStackTrace();
        }
    }
}
