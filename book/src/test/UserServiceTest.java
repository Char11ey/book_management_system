package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.iml.UserServiceImpl;

/**
 * @author Charley
 * @creat 2021-05-27 16:56
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"Jack","12345","jack@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"Jack","12345",null)));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("admin")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}