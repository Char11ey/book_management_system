package dao;

import pojo.User;

/**
 * @author Charley
 * @creat 2021-05-27 12:19
 */
public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username,String password);

    public int saveUser(User user);
}
