package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Adresse;

import java.util.List;

public interface AdresseDAO {
    public void createAdresse(EntityManager em, Adresse a);
    public Adresse getAdresseById(EntityManager em, int idAdresse);
    public List<Adresse> getAllAdresses(EntityManager em);
    public void updateAdresse(EntityManager em, Adresse a);
    public void deleteAdresse(EntityManager em, int idAdresse);
}
