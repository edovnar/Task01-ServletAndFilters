package service;

import domain.Order;
import domain.User;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import persistance.dao.OrderDAO;
import utils.UserContext;

import java.util.Set;


public class OrderService {

    public static Set<Order> getOrdersFromCurrentUser() throws UserNotFoundException {
        return OrderDAO.getByUserName(UserContext.getCurrentUser().getName());
    }

    public static Order getOrderById(String id) throws OrderNotFoundException {
        return OrderDAO.getById(id);
    }

    /**
     * Find an order with the @param id from FakeDB.
     * If there is no such order throws OrderNotFoundException.
     * Check if the order was submitted by Current user,
     * if it was - return order, else return empty Order(?).
     * @param id
     * @return Order (required if OK, empty - is not OK)
     * @throws OrderNotFoundException
     */
    public static Order getOrderByIdFromCurrentUser(String id) throws OrderNotFoundException {
        Order order = OrderDAO.getById(id);
        User user = UserContext.getCurrentUser();
            if(order.getSubmittedBy().equals(user.getName()))
                return order;
        return new Order();
    }

    /**
     * Check whether the order with the item, that User want to order, has already been posted.
     * If it has been posted, add Quantities of new and old Orders together and set it to the old one,
     * no new Order creation.
     * If it hasn't been posted, create a new Order.
     * @param order
     * @throws UserNotFoundException
     */
    public static void postOrder(Order order) throws UserNotFoundException {
        Order oldOrder = OrderDAO.getByUserName(UserContext.getCurrentUser().getName()).stream()
                .filter(oldO -> oldO.getItem().equals(order.getItem()))
                .findAny()
                .orElse(null);

        if(oldOrder != null) {
            oldOrder.setQuantity(oldOrder.getQuantity() + order.getQuantity());
        } else{
            OrderDAO.create(order);
        }
    }
}
