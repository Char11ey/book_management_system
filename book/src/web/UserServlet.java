package web;

import pojo.User;
import service.UserService;
import service.iml.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * @author Charley
 * @creat 2021-07-08 15:00
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if(token != null && token.equalsIgnoreCase(code)){
            if(userService.existUsername(user.getUsername())){
                req.setAttribute("msg","用户名已存在！！");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                System.out.println("用户名[" + user.getUsername() + "]已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("msg","验证码错误！！");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        User loginUser = userService.login(user);
        if(loginUser == null){
            req.setAttribute("msg","用户名或密码错误！！");
            req.setAttribute("username",user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("loginUser", loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}
