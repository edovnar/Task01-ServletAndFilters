package ioc.persistence;

import ioc.domain.Order;
import ioc.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeDB {

    private List<User> users = List.of(
            new User("admin", "admin"),
            new User("vice-admin","admin"));

    private List<Order> orders = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
