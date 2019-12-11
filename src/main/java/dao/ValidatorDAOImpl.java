package dao;

import org.springframework.stereotype.Repository;
import utils.Manager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
@Repository
public class ValidatorDAOImpl implements ValidatorDAO {

    @Override
    public boolean checkLogin(String login) {
        EntityManager manager = Manager.getFactory().createEntityManager();
        Query q = manager.createNativeQuery("SELECT * from jpa.users where jpa.users.Login= :paramLogin");
        q.setParameter("paramLogin", login);
        try {
            q.getSingleResult();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
