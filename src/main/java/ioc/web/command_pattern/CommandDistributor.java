package ioc.web.command_pattern;

import ioc.exception.CommandNotFoundException;
import ioc.web.command_pattern.command.GetOrderByIDCommand;
import ioc.web.command_pattern.command.GetOrderCommand;
import ioc.web.command_pattern.command.PostOrderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandDistributor {

    public Command getCommand(String uri, String method) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ioc");

        if (uri.split("/").length == 3 && uri.split("/")[1].equals("orders")){
            uri = "/orders/{id}";
        }

        if (method.equals("POST")) {
            if ("/orders".equals(uri)) {
                return context.getBean(PostOrderCommand.class);
            }
            throw new CommandNotFoundException();
        } else if (method.equals("GET")) {
            return switch (uri) {
                case "/orders" -> context.getBean(GetOrderCommand.class);
                case "/orders/{id}" -> context.getBean(GetOrderByIDCommand.class);
                default -> throw new CommandNotFoundException();
            };
        } else {
             throw  new CommandNotFoundException();
        }
    }
}
