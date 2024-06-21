package projet.dao;

import projet.Personne;

import java.util.List;

public interface PersonneDAO {
    public void createPersonne(Personne a);
    public Personne getPersonneById(int idPersonne);
    public List<Personne> getAllPersonnes();
    public void updatePersonne(Personne a);
    public void deletePersonne(int idPersonne);
}
