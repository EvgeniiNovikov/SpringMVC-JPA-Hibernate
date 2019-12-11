package services;

import dao.DAOUser;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceHibernateImpl implements UserServiceHibernate {

    private DAOUser dao;

    @Autowired
    public void setDao(DAOUser dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public User checkUser(String login, String password) {
        return dao.checkUser(login, password);
    }

    @Override
    @Transactional
    public List<User> getUser(String login, String password) {
        return dao.getUser(login, password);
    }
}
