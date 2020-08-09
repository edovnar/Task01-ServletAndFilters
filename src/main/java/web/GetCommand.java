package web;

import exception.UserNotFoundException;
import service.OrderService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/*")
public class GetCommand extends Application {

    @GET
    public Response getOrders() throws UserNotFoundException {
        return Response.status(200).entity(OrderService.getOrdersByCurrentUser().toString()).build();
    }

//    public GetCommand(HttpServletResponse resp,
//                      HttpServletRequest req) {
//        super(resp, req);
//    }
//
//    @Override
//    public void execute() {
//        String[] parts = req.getPathInfo().split("/");
//        if (parts.length == 2) {
//            try {
//                resp.getWriter().write(OrderService.getOrdersByCurrentUser().toString());
//            } catch (IOException | UserNotFoundException e) {
//                e.printStackTrace();
//            }
//        } else if(parts.length == 3){
//            try {
//                resp.getWriter().write(
//                        OrderService.getOrderByIdFromCurrentUser(parts[3]).toString());
//            } catch (IOException| OrderNotFoundException e) {
//                e.printStackTrace();
//            }
//        } else{
//            try {
//                resp.getWriter().write("let's try again");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
