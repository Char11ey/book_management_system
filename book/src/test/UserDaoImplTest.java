package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

import static org.junit.Assert.*;

/**
 * @author Charley
 * @creat 2021-05-27 12:41
 */
public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin1") == null){
            System.out.println("用户不存在");
        }else {
            System.out.println("用户已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("Mike","134") == null){
            System.out.println("用户名错误或密码错误");
        }else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser
                (new User(null,"Mike","1234","Mike@123.com")));
    }
}