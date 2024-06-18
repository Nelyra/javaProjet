package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Adresse;

public interface AdresseDAO {
    public void createAdresse(EntityManager em, Adresse a);
    public Adresse getAdresseById(EntityManager em, int idAdresse);
    public void updateAdresse(EntityManager em, Adresse a);
    public void deleteAdresse(EntityManager em, int idAdresse);
}
