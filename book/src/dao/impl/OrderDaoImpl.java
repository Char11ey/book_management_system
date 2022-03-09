package dao.impl;

import dao.OrderDao;
import pojo.Order;

import java.util.List;

/**
 * @author Charley
 * @creat 2021-07-19 22:24
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public void saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) " +
                "values(?,?,?,?,?)";
        update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order";
        return queryForList(Order.class, sql );
    }

}
