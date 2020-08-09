package service;

import domain.Order;
import domain.User;
import persistance.dao.OrderDAO;
import persistance.dao.UserDAO;
import utils.UserContext;

import java.util.List;

public class OrderService {

    public static List<Order> getOrdersByCurrentUser(){
            return OrderDAO.getByUser(UserContext.getCurrentUser());
    }

    public static Order getOrderById(String id){
        Order order = OrderDAO.getById(id);
        User user = UserContext.getCurrentUser();
        if(order.getSubmittedBy().equals(user.getName()))
            return order;
        else return null;
    }

    public static void postOrder(Order order){
        OrderDAO.create(order);
        UserDAO.getUserByName(
                UserContext.getCurrentUser().getName()
        )
                .getOrders().add(order);
    }
}
