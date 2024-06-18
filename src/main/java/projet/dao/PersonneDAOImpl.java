package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Personne;

import java.util.List;

public class PersonneDAOImpl implements PersonneDAO {
    @Override
    public void createPersonne(EntityManager em, Personne a) {
        em.persist(a);
    }

    @Override
    public Personne getPersonneById(EntityManager em, int idPersonne) {
        return em.find(Personne.class, idPersonne);
    }

    @Override
    public List<Personne> getAllPersonnes(EntityManager em) {
        return em.createQuery("SELECT a FROM Personne a", Personne.class).getResultList();
    }
    public void updatePersonne(EntityManager em, Personne a) {
        em.merge(a);
    }

    @Override
    public void deletePersonne(EntityManager em, int idPersonne) {
        Personne a = em.find(Personne.class, idPersonne);
        em.remove(a);
    }
}
