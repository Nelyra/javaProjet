package projet.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projet.Etatdeslieux;

import java.util.List;

public class EtatdeslieuxDAOImpl implements EtatdeslieuxDAO {
    @Override
    public void createEtatdeslieux(Etatdeslieux a) {
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
    public Etatdeslieux getEtatdeslieuxById(int idEtatdeslieux) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Etatdeslieux a = em.find(Etatdeslieux.class, idEtatdeslieux);

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
    public List<Etatdeslieux> getAllEtatdeslieux() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                List<Etatdeslieux> a = em.createQuery("SELECT a FROM Etatdeslieux a", Etatdeslieux.class).getResultList();

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
    public void updateEtatdeslieux(Etatdeslieux a) {
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
    public void deleteEtatdeslieux(int idEtatdeslieux) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Etatdeslieux a = em.find(Etatdeslieux.class, idEtatdeslieux);
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
