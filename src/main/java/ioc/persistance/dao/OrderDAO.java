package ioc.persistance.dao;

import ioc.domain.Order;
import ioc.persistance.FakeDB;
import ioc.utils.UserContext;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderDAO{

    FakeDB db;

    private OrderDAO(FakeDB db) {
        this.db = db;
    }

    public Set<Order> getByUserName(String userName){
        return  db.getOrders().stream()
                .filter(order -> order.getSubmittedBy().equals(userName))
                .collect(Collectors.toSet());
    }

    public Optional<Order> getById(String id){
        return  db.getOrders().stream()
                .filter(order -> order.getId().equals(id))
                .findAny();
    }

    /**
     * Set field subbmitedBy(Order) with the Name of current User
     * add such Order to the list of Orders, which current User has,
     * then add Order to the FakeDB.
     * @param order
     */

    public void create(Order order){
        order.setSubmittedBy(UserContext.getCurrentUser().getName());
        db.getOrders().add(order);
    }
}
