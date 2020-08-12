package persistance.dao;

import domain.Order;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import persistance.FakeDB;
import utils.UserContext;

import java.util.List;
import java.util.Set;

public class OrderDAO{

    private OrderDAO() { }

        private static class Singleton{
            public static final OrderDAO INSTANCE = new OrderDAO();
        }

    public static OrderDAO getInstance(){ return Singleton.INSTANCE; }

    public List<Order> getAll(){
        return FakeDB.getInstance().getOrders();
    }

    public Set<Order> getByUserName(String userName) throws UserNotFoundException {
        return (FakeDB.getInstance().getUsers().stream()
                .filter(u -> u.getName().equals(userName))
                .findAny()
                .orElseThrow(UserNotFoundException::new)
        ).getOrders();
    }

    public Order getById(String id) throws OrderNotFoundException {
        return FakeDB.getInstance().getOrders().stream()
                .filter(order -> order.getId().equals(id))
                .findAny()
                .orElseThrow(OrderNotFoundException::new);
    }

    public void deleteById(String id) throws OrderNotFoundException {
        FakeDB.getInstance().getOrders()
                .remove(
                    FakeDB.getInstance().getOrders().stream()
                    .filter(order -> order.getId().equals(id))
                    .findAny()
                    .orElseThrow(OrderNotFoundException::new)
        );
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
