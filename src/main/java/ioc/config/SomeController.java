package ioc.config;

import ioc.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class SomeController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Order getOrder() {
        System.out.println("nonono");
        return new Order();
    }
}
