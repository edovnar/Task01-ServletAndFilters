package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String password;
    private List<Order> orders;

    public User() { }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        orders  = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

}
