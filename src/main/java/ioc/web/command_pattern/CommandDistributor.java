package ioc.web.command_pattern;

import ioc.domain.Order;
import ioc.utils.AppContext;
import ioc.web.command_pattern.command.GetOrderByIDCommand;
import ioc.web.command_pattern.command.PostOrderCommand;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/")
public class CommandDistributor {

    @RequestMapping(method = RequestMethod.GET)
    public Set getOrders() {
        System.out.println("hellloooooo");
        return new HashSet<Order>();
        //return AppContext.getContext().getBean(GetOrderCommand.class).execute();
    }

    @RequestMapping(value = "orders", method = RequestMethod.POST)
    public String postOrder(@RequestBody Order order) {
        return AppContext.getContext().getBean(PostOrderCommand.class).execute(order);
    }

    @RequestMapping(value = "orders/{id}", method = RequestMethod.GET, produces = "application/json")
    public Order getOrderByID(@PathVariable String id){
        return AppContext.getContext().getBean(GetOrderByIDCommand.class).execute(id);
    }
}
