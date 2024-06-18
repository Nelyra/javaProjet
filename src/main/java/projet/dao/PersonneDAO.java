package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Personne;

public interface PersonneDAO {
    public void createPersonne(EntityManager em, Personne a);
    public Personne getPersonneById(EntityManager em, int idPersonne);
    public void updatePersonne(EntityManager em, Personne a);
    public void deletePersonne(EntityManager em, int idPersonne);
}
