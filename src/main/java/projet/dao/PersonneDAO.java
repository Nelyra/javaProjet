package projet.dao;

import projet.Personne;

import java.util.List;

public interface PersonneDAO {
    public void createPersonne(Personne a);
    public Personne getPersonneById(int idPersonne);
    public List<Personne> getAllPersonnes();
    public  List<Personne> getAllLocataires();
    public  List<Personne> getAllProprietaires();
    public void updatePersonne(Personne a);
    public void deletePersonne(int idPersonne);
}
