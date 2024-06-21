package projet.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projet.Bail;

import java.util.List;

public class BailDAOImpl implements BailDAO {
    @Override
    public void createBail(Bail a) {
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
    public Bail getBailById(int idBail) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Bail a = em.find(Bail.class, idBail);

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
    public List<Bail> getAllBails() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                List<Bail> a = em.createQuery("SELECT a FROM Bail a", Bail.class).getResultList();

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
    public void updateBail(Bail a) {
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
    public void deleteBail(int idBail) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Bail a = em.find(Bail.class, idBail);
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
