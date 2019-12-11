package dao;

import models.User;

import java.util.List;


public interface DAOUser {
    List<User> getAllUsers();
    void addUser(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    User checkUser(String l, String p);
    List<User> getUser(String login, String password);
}
