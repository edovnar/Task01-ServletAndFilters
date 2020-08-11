package persistance;

import domain.Order;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {

    private static FakeDB instance;

    private List<User> users = List.of(
            new User("admin", "admin"),
            new User("vice-admin","admin"));

    private List<Order> orders = new ArrayList<>();

    private FakeDB(){}

    public static synchronized FakeDB getInstance(){
        if(instance == null) {
            instance = new FakeDB();
        }
        return instance;
    }

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
