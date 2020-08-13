package service;

import domain.Order;
import domain.User;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import persistance.dao.OrderDAO;
import utils.UserContext;

import java.util.Set;


public class OrderService {

    private OrderDAO orderDAO;

    private OrderService() {
        this.orderDAO = OrderDAO.getInstance();
    }

    private static class Singleton{
        public static final OrderService INSTANCE = new OrderService();
    }

    public static OrderService getInstance(){ return OrderService.Singleton.INSTANCE; }


    public Set<Order> getOrdersFromCurrentUser() throws OrderNotFoundException {
        return orderDAO.getByUserName(UserContext.getCurrentUser().getName())
                .orElseThrow(OrderNotFoundException::new);
    }

    /**
     * Find an order with the @param id from FakeDB.
     * If there is no such order throws OrderNotFoundException.
     * Check if the order was submitted by Current user,
     * if it was - return order, else return empty Order(?).
     * @param id - id of order that want to be found
     * @return Order (required if OK, empty - is not OK)
     * @throws OrderNotFoundException
     */

    public Order getOrderByIdFromCurrentUser(String id) throws OrderNotFoundException {
        Order order = orderDAO.getById(id)
                .orElseThrow(OrderNotFoundException::new);
        User user = UserContext.getCurrentUser();

            if(order.getSubmittedBy().equals(user.getName())){
                return order;
            } else {
                throw new OrderNotFoundException();
            }
    }

    /**
     * Check whether the order with the item, that User want to order, has already been posted.
     * If it has been posted, add Quantities of new and old Orders together and set it to the old one,
     * no new Order creation.
     * If it hasn't been posted, create a new Order.
     * @param order
     * @throws UserNotFoundException
     */
    public void postOrder(Order order) throws OrderNotFoundException {
        Order oldOrder = orderDAO.getByUserName(UserContext.getCurrentUser().getName())
                .orElseThrow(OrderNotFoundException::new)
                .stream()
                .filter(oldO -> oldO.getItem().equals(order.getItem()))
                .findAny()
                .orElse(null);

        if(oldOrder != null) {
            oldOrder.setQuantity(oldOrder.getQuantity() + order.getQuantity());
        } else{
            orderDAO.create(order);
        }
    }
}
