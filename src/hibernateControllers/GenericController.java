package hibernateControllers;
import model.Driver;
import model.Driver;
import model.Manager;
import model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericController {

    private EntityManagerFactory entityManagerFactory;

    public GenericController(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
    }

    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public <T> void create(T entity){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(em!=null) em.close();
        }
    }

    public <T> void update(T entity){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(em!=null) em.close();
        }
    }
    public <T> void delete(T entity){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(em!=null) em.close();
        }
    }

  public <T> List<T> getAllRecords(Class<T> entity){
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            query.select(query.from(entity));
            Query q = em.createQuery(query);
            return q.getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
      }finally {
            if(em!=null) em.close();
        }
        return null;

  }

    public <T> T getEntityById(Class<T> entity, int id){
        EntityManager em = getEntityManager();
        T result = null;
        try{
            em.getTransaction().begin();
            result = em.find(entity,id);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            if(em!=null) em.close();
        }
        return result;
    }

    public User findUserByCredentials(String login, String password) throws Exception{
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Try to find a Driver first
        CriteriaQuery<Driver> driverQuery = cb.createQuery(Driver.class);
        Root<Driver> driverRoot = driverQuery.from(Driver.class);
        driverQuery.select(driverRoot).where(cb.and(cb.like(driverRoot.get("login"), login)), cb.like(driverRoot.get("password"), password));
        Query driverTypedQuery = em.createQuery(driverQuery);

        try {
            return (Driver) driverTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            // Could not find a Driver, so search for a Manager instead
            CriteriaQuery<Manager> managerQuery = cb.createQuery(Manager.class);
            Root<Manager> managerRoot = managerQuery.from(Manager.class);
            managerQuery.select(managerRoot).where(cb.and(cb.like(managerRoot.get("login"), login)), cb.like(managerRoot.get("password"), password));
            Query managerTypedQuery = em.createQuery(managerQuery);

            try {
                return (Manager) managerTypedQuery.getSingleResult();
            } catch (NoResultException ex) {
                return null;
            }
        }
    }


}
