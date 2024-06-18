package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Adresse;

import java.util.List;

public class AdresseDAOImpl implements AdresseDAO {
    @Override
    public void createAdresse(EntityManager em, Adresse a) {
        em.persist(a);
    }
    @Override
    public Adresse getAdresseById(EntityManager em, int idAdresse) {
        return em.find(Adresse.class, idAdresse);
    }
    public List<Adresse> getAllAdresses(EntityManager em) {
        return em.createQuery("SELECT a FROM Adresse a", Adresse.class).getResultList();
    }
    @Override
    public void updateAdresse(EntityManager em, Adresse a) {
        em.merge(a);
    }
    @Override
    public void deleteAdresse(EntityManager em, int idAdresse) {
        Adresse a = em.find(Adresse.class, idAdresse);
        em.remove(a);
    }
}
