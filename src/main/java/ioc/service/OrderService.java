package ioc.service;

import ioc.domain.Order;
import ioc.domain.User;
import ioc.exception.OrderNotFoundException;
import ioc.exception.UserNotFoundException;
import ioc.persistence.dao.OrderDAO;
import ioc.utils.UserContext;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderService {

    private OrderDAO orderDAO;

    private OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Set<Order> getOrdersFromCurrentUser() {
        return orderDAO.getByUserName(UserContext.getCurrentUser().getName());
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

    public Order getOrderByIdFromCurrentUser(String id){
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
    public void postOrder(Order order){
        orderDAO.getByUserName(UserContext.getCurrentUser().getName())
                .stream()
                .filter(existingOrder -> existingOrder.getItem().equals(order.getItem()))
                .findAny()
                .ifPresentOrElse(
                        existingOrder -> existingOrder.setQuantity(existingOrder.getQuantity() + order.getQuantity()),
                        () ->  orderDAO.create(order)
                );
    }
}
