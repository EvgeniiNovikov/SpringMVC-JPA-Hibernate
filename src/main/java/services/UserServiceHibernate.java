package services;


import models.User;

import java.util.List;

public interface UserServiceHibernate {
    List<User> getAllUsers();
    void addUser(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    User checkUser(String l, String p);
    List<User> getUser(String login, String password);
}
