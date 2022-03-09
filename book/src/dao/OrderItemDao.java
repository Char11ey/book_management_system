package dao;

import pojo.OrderItem;

/**
 * @author Charley
 * @creat 2021-07-19 22:32
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
}
