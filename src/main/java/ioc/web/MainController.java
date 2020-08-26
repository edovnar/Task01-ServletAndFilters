package ioc.web;

import ioc.domain.Order;
import ioc.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/orders")
public class MainController {

    private OrderService orderService;

    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Set<Order> getOrders() {
       return orderService.getOrdersFromCurrentUser();
    }

    @PostMapping
    public String postOrder(@RequestBody Order order) {
        orderService.postOrder(order);
        return "Order is accepted";
    }

    @GetMapping(value = "/{id}")
    public Order getOrderByID(@PathVariable String id){
        return orderService.getOrderByIdFromCurrentUser(id);
    }
}
