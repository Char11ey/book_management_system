package service;

import pojo.User;

/**
 * @author Charley
 * @creat 2021-05-27 16:47
 */
public interface UserService {
    public void registerUser(User user);

    public User login(User user);

    public boolean existUsername(String username);
}
