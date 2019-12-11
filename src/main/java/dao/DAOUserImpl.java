package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.Manager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DAOUserImpl implements DAOUser {


//    private EntityManager entityManager;
//
//    @Autowired
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) Manager.getFactory().createEntityManager().createQuery("from models.User").getResultList();
    }

    @Override
    public void addUser(User user) {
//        EntityManager manager = Manager.getFactory().createEntityManager();
//        manager.getTransaction().begin();
//        manager.persist(user);
//        manager.getTransaction().commit();
//        manager.close();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(User user) {
        EntityManager manager = Manager.getFactory().createEntityManager();
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager manager = Manager.getFactory().createEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.find(User.class, id));
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public User findById(int id) {
        return Manager.getFactory().createEntityManager().find(User.class, id);
    }

    @Override
    public User checkUser(String login, String password) {
        EntityManager manager = Manager.getFactory().createEntityManager();
        Query q = manager.createNativeQuery("select * from jpa.users WHERE jpa.users.Login= :paramLogin and jpa.users.Password= :paramPassword", User.class);
        q.setParameter("paramLogin", login);
        q.setParameter("paramPassword", password);
        User user = (User) q.getSingleResult();
        manager.close();
        return user;
    }

    @Override
    public List<User> getUser(String login, String password) {
        EntityManager manager = Manager.getFactory().createEntityManager();
        Query q = manager.createNativeQuery("select * from jpa.users WHERE jpa.users.Login= :paramLogin and jpa.users.Password= :paramPassword", User.class);
        q.setParameter("paramLogin", login);
        q.setParameter("paramPassword", password);
        List<User> users = (List<User>) q.getResultList();
        manager.close();
        return users;
    }
}
