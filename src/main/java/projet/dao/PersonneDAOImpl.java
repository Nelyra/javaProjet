package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Personne;

public class PersonneDAOImpl implements PersonneDAO {
    public void createPersonne(EntityManager em, Personne a) {
        em.persist(a);
    }

    public Personne getPersonneById(EntityManager em, int idPersonne) {
        return em.find(Personne.class, idPersonne);
    }

    public void updatePersonne(EntityManager em, Personne a) {
        em.merge(a);
    }

    public void deletePersonne(EntityManager em, int idPersonne) {
        Personne a = em.find(Personne.class, idPersonne);
        em.remove(a);
    }
}
