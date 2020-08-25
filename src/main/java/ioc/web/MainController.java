package ioc.web;

import ioc.domain.Order;
import ioc.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/orders")
public class MainController {

    private final OrderService orderService;

    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<Order> getOrders() {
       return orderService.getOrdersFromCurrentUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postOrder(@RequestBody Order order) {
        orderService.postOrder(order);
        return "Order is accepted";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getOrderByID(@PathVariable String id){
        return orderService.getOrderByIdFromCurrentUser(id);
    }
}
