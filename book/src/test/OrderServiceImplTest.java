package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;
import pojo.Order;
import service.OrderService;
import service.iml.OrderServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Charley
 * @creat 2021-07-19 22:50
 */
public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));
        OrderService orderService = new OrderServiceImpl();
        String order = orderService.createOrder(cart, 1);
        System.out.println(order);
    }

    @Test
    public void showAllOrders(){
        OrderService orderService = new OrderServiceImpl();
        List<Order> orders = orderService.showAllOrders();
        for(Order order : orders){
            System.out.println(order);
        }
    }
}