package domain;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private String password;
    private Set<Order> orders;

    public User() { }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        orders  = new HashSet<>();
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

    public Set<Order> getOrders() { return orders; }
    public void setOrders(Set<Order> orders) { this.orders = orders; }

}
