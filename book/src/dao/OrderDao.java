package dao;

import pojo.Order;

import java.util.List;

/**
 * @author Charley
 * @creat 2021-07-19 22:18
 */
public interface OrderDao {
    void saveOrder(Order order);

    List<Order> queryOrders();
}
