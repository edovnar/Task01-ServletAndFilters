package persistance.dao;

import domain.Order;
import domain.User;
import persistance.FakeDB;

import java.util.List;

public class OrderDAO{
//todo exceptions null
    public static List<Order> getAll(){
        return FakeDB.getInstance().getOrders();
    }

    public static List<Order> getByUser(User user){
        return (FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(user.getName()) &&
                            u.getPassword().equals(user.getPassword()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such user..."))
        ).getOrders();
    }

    public static Order getById(String id){
        return FakeDB.getInstance().getOrders().stream()
                .filter(order -> order.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public static void deleteById(String id){
        FakeDB.getInstance().getOrders()
                .remove(
                    FakeDB.getInstance().getOrders().stream()
                    .filter(order -> order.getId().equals(id))
                    .findAny()
                    .orElse(null)
        );
    }

    public static void create(Order order){
        FakeDB.getInstance().getOrders().add(order);
    }

}
