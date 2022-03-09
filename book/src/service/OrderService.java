package service;

import pojo.Cart;
import pojo.Order;

import java.util.List;

/**
 * @author Charley
 * @creat 2021-07-19 22:36
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);

    List<Order> showAllOrders();
}
