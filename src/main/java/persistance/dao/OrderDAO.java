package persistance.dao;

import domain.Order;
import domain.User;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import persistance.FakeDB;
import utils.UserContext;

import java.util.List;

public class OrderDAO{
//todo exceptions null
    public static List<Order> getAll(){
        return FakeDB.getInstance().getOrders();
    }

    public static List<Order> getByUser(User user) throws UserNotFoundException {
        return (FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(user.getName()) &&
                            u.getPassword().equals(user.getPassword()))
                .findAny()
                .orElseThrow(UserNotFoundException::new)
        ).getOrders();
    }

    public static Order getById(String id) throws OrderNotFoundException {
        return FakeDB.getInstance().getOrders().stream()
                .filter(order -> order.getId().equals(id))
                .findAny()
                .orElseThrow(OrderNotFoundException::new);
    }

    public static void deleteById(String id) throws OrderNotFoundException {
        FakeDB.getInstance().getOrders()
                .remove(
                    FakeDB.getInstance().getOrders().stream()
                    .filter(order -> order.getId().equals(id))
                    .findAny()
                    .orElseThrow(OrderNotFoundException::new)
        );
    }

    public static void create(Order order){
        UserContext.getCurrentUser().getOrders().add(order);
        FakeDB.getInstance().getOrders().add(order);
    }
}
