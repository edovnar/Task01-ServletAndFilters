package persistance.dao;

import domain.Order;
import persistance.FakeDB;
import utils.UserContext;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDAO{

    private OrderDAO() { }

        private static class Singleton{
            public static final OrderDAO INSTANCE = new OrderDAO();
        }

    public static OrderDAO getInstance(){ return Singleton.INSTANCE; }


    public Set<Order> getByUserName(String userName){
        return FakeDB.getInstance().getOrders().stream()
                .filter(order -> order.getSubmittedBy().equals(userName))
                .collect(Collectors.toSet());
    }

    public Optional<Order> getById(String id){
        return FakeDB.getInstance().getOrders().stream()
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
        FakeDB.getInstance().getOrders().add(order);
    }
}
