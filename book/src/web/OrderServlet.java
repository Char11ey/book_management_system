package web;

import dao.impl.BaseDao;
import pojo.Cart;
import pojo.Order;
import pojo.User;
import service.OrderService;
import service.iml.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Charley
 * @creat 2021-07-19 22:49
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void creatOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User)req.getSession().getAttribute("loginUser");
        if(loginUser == null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("pages/order/order.jsp").forward(req, resp);
    }
}
