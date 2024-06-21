package projet.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projet.Location;

import java.util.List;

public class LocationDAOImpl implements LocationDAO {
    @Override
    public void createLocation(Location a) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                em.persist(a);

                et.commit();
            } catch (Exception e) {
                et.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            if (em != null && em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }

    @Override
    public Location getLocationById(int idLocation) {
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Location a = em.find(Location.class, idLocation);

                et.commit();
                return a;
            } catch (Exception e) {
                et.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            if (em != null && em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }

    @Override
    public List<Location> getAllLocations() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                List<Location> a = em.createQuery("SELECT a FROM Location a", Location.class).getResultList();

                et.commit();
                return a;
            } catch (Exception e) {
                et.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            if (em != null && em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }

    @Override
    public void updateLocation(Location a) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                em.merge(a);

                et.commit();
            } catch (Exception e) {
                et.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            if (em != null && em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }

    @Override
    public void deleteLocation(int idLocation) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Location a = em.find(Location.class, idLocation);
                em.remove(a);

                et.commit();
            } catch (Exception e) {
                et.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            if (em != null && em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }
}
