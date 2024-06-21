package projet.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import projet.Personne;

import java.util.List;

public class PersonneDAOImpl implements PersonneDAO {
    @Override
    public void createPersonne(Personne a) {
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
    public Personne getPersonneById(int idPersonne) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Personne a = em.find(Personne.class, idPersonne);

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
    public List<Personne> getAllPersonnes() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                List<Personne> personnes = em.createQuery("SELECT a FROM Personne a", Personne.class).getResultList();

                et.commit();
                return personnes;
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

    public void updatePersonne(Personne a) {
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
    public void deletePersonne(int idPersonne) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final jakarta.persistence.EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Personne a = em.find(Personne.class, idPersonne);
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
