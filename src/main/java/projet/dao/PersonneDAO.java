package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Personne;

import java.util.List;

public interface PersonneDAO {
    public void createPersonne(EntityManager em, Personne a);
    public Personne getPersonneById(EntityManager em, int idPersonne);
    public List<Personne> getAllPersonnes(EntityManager em);
    public void updatePersonne(EntityManager em, Personne a);
    public void deletePersonne(EntityManager em, int idPersonne);
}
