package persistance;

import domain.Order;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private List<User> users = List.of(
            new User("admin", "admin"),
            new User("vice-admin","admin"));

    private List<Order> orders = new ArrayList<>();

    private FakeDB() { }

    private static class Singleton{
        public static final FakeDB INSTANCE = new FakeDB();
    }

    public static FakeDB getInstance(){ return FakeDB.Singleton.INSTANCE; }

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
