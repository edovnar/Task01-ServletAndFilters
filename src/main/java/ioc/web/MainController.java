package ioc.web;

import ioc.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {

    @GetMapping
    public User getOrder() {
        System.out.println("hiii");
        return new User("hi", "there");
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
