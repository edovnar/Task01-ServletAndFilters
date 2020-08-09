package service;

import domain.Order;
import domain.User;
import exception.OrderNotFoundException;
import exception.UserNotFoundException;
import persistance.dao.OrderDAO;
import utils.UserContext;

import java.util.List;


public class OrderService {

    public static List<Order> getOrdersByCurrentUser() throws UserNotFoundException {
        return OrderDAO.getByUser(UserContext.getCurrentUser());
    }

    public static Order getOrderById(String id) throws OrderNotFoundException {
        return OrderDAO.getById(id);
    }

    public static Order getOrderByIdFromCurrentUser(String id) throws OrderNotFoundException {
        Order order = OrderDAO.getById(id);
        User user = UserContext.getCurrentUser();
            if(order.getSubmittedBy().equals(user.getName()))
                return order;
        return null;
    }

    public static void postOrder(Order order) throws UserNotFoundException {
        Order oldOrder = OrderDAO.getByUser(UserContext.getCurrentUser()).stream()
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
