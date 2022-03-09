package web;

import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.iml.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Charley
 * @creat 2021-07-19 17:00
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.pareInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", book.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.pareInt(req.getParameter("id"), 0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.deleteItem(id);
        }
        req.getSession().setAttribute("lastName", null);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.pareInt(req.getParameter("id"), 0);
        int count = WebUtils.pareInt(req.getParameter("count"), 1);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            cart.updateCount(id, count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
