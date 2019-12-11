package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static final String PERSISTENCE_UNIT_NAME = "pepsi";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getFactory() {
        if (factory == null) {
            try {
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

}
