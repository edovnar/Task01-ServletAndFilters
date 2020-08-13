package persistance.dao;

import domain.Order;
import persistance.FakeDB;
import utils.UserContext;

import java.util.Optional;
import java.util.Set;

public class OrderDAO{

    private OrderDAO() { }

        private static class Singleton{
            public static final OrderDAO INSTANCE = new OrderDAO();
        }

    public static OrderDAO getInstance(){ return Singleton.INSTANCE; }


    public Optional<Set<Order>> getByUserName(String userName){
        return Optional.of(FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(userName))
                .findAny()
                .get()
                .getOrders());
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
        UserContext.getCurrentUser().getOrders().add(order);
        FakeDB.getInstance().getOrders().add(order);
    }
}
