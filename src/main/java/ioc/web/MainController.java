package ioc.web;

import ioc.domain.Order;
import ioc.domain.User;
import ioc.service.OrderService;
import ioc.utils.UserContext;
import org.springframework.context.access.ContextBeanFactoryReference;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController("/")
@RequestMapping
public class MainController {
    private OrderService orderService;

    public MainController(OrderService orderService){
        this.orderService = orderService;

    }

    @RequestMapping(params = "/orders", method = RequestMethod.GET)
    public Set getOrders() {
        return orderService.getOrdersFromCurrentUser();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String postOrder(@RequestBody Order order) {
        orderService.postOrder(order);
        return "Order is accepted";
    }

    @RequestMapping(value = "orders/{id}", method = RequestMethod.GET, produces = "application/json")
    public Order getOrderByID(@PathVariable String id){
        return orderService.getOrderByIdFromCurrentUser(id);
    }
}
