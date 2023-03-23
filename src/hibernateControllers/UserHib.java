package hibernateControllers;

import model.Manager;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserHib {
    private EntityManagerFactory emf;

    public UserHib(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }


    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void createManager(Manager manager) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(manager);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }
}
