package ioc.web;

import ioc.domain.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MainController {
    static

    @GetMapping(path = "/orders")
    public Order getOrder() {
        return new Order();
    }
//        return AppContext.getContext().getBean(GetOrderCommand.class).execute();
//    }
//
//    @RequestMapping(value = "orders", method = RequestMethod.POST)
//    public String postOrder(@RequestBody Order order) {
//        return We.getContext().getBean(PostOrderCommand.class).execute(order);
//    }
//
//    @RequestMapping(value = "orders/{id}", method = RequestMethod.GET, produces = "application/json")
//    public Order getOrderByID(@PathVariable String id){
//        return AppContext.getContext().getBean(GetOrderByIDCommand.class).execute(id);
//    }
}
