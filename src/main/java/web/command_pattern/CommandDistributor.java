package web.command_pattern;

import exception.OrderNotFoundException;
import web.command_pattern.command.GetOrderByIDCommand;
import web.command_pattern.command.GetOrderCommand;
import web.command_pattern.command.PostOrderCommand;

public class CommandDistributor {

    private CommandDistributor(){}

        private static class Singleton{
            private static final CommandDistributor INSTANCE = new CommandDistributor();
        }

    public static CommandDistributor getInstance(){
        return Singleton.INSTANCE;
    }

    public Command getCommand(String uri, String method) throws OrderNotFoundException {

        if (uri.split("/").length == 3){
            uri = "/order/{id}";
        }

        if (method.equals("POST")) {
            switch (uri) {
                case "/orders": return PostOrderCommand.getInstance();
            }
        } else if (method.equals("GET")) {
            switch (uri) {
                case "/orders": return GetOrderCommand.getInstance();
                case "/order/{id}": return GetOrderByIDCommand.getInstance();
            }
        } else throw new OrderNotFoundException();
        return null;
    }
}
