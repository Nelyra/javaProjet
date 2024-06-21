package projet.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projet.Adresse;

import java.util.List;

public class AdresseDAOImpl implements AdresseDAO {
    @Override
    public void createAdresse(Adresse a) {
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
    public Adresse getAdresseById(int idAdresse) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Adresse a = em.find(Adresse.class, idAdresse);

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
    public List<Adresse> getAllAdresses() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                List<Adresse> a = em.createQuery("SELECT a FROM Adresse a", Adresse.class).getResultList();

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
    public void updateAdresse(Adresse a) {
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
    public void deleteAdresse(int idAdresse) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Adresse a = em.find(Adresse.class, idAdresse);
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
