package web.command_pattern;

import exception.CommandNotFoundException;
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

    public Command getCommand(String uri, String method) {

        if (uri.split("/").length == 3 && uri.split("/")[1].equals("orders")){
            uri = "/orders/{id}";
        }

        if (method.equals("POST")) {
            if ("/orders".equals(uri)) {
                return PostOrderCommand.getInstance();
            }
            throw new CommandNotFoundException();
        } else if (method.equals("GET")) {
            return switch (uri) {
                case "/orders" -> GetOrderCommand.getInstance();
                case "/orders/{id}" -> GetOrderByIDCommand.getInstance();
                default -> throw new CommandNotFoundException();
            };
        } else {
             throw  new CommandNotFoundException();
        }
    }
}
