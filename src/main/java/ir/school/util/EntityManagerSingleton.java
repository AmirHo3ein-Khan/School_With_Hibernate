package ir.school.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EntityManagerSingleton {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManagerSingleton() {}
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            synchronized (EntityManagerSingleton.class) {
                if (entityManagerFactory == null) {
                    entityManagerFactory = Persistence.createEntityManagerFactory("jdbc-postgres");
                }
            }
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
