package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Etatdeslieux;

import java.util.List;

public class EtatdeslieuxDAOImpl implements EtatdeslieuxDAO {
    @Override
    public void createEtatdeslieux(EntityManager em, Etatdeslieux a) {
        em.persist(a);
    }

    @Override
    public Etatdeslieux getEtatdeslieuxById(EntityManager em, int idEtatdeslieux) {
        return em.find(Etatdeslieux.class, idEtatdeslieux);
    }

    @Override
    public List<Etatdeslieux> getAllEtatdeslieux(EntityManager em) {
        return em.createQuery("SELECT a FROM Etatdeslieux a", Etatdeslieux.class).getResultList();
    }

    @Override
    public void updateEtatdeslieux(EntityManager em, Etatdeslieux a) {
        em.merge(a);
    }

    @Override
    public void deleteEtatdeslieux(EntityManager em, int idEtatdeslieux) {
        Etatdeslieux a = em.find(Etatdeslieux.class, idEtatdeslieux);
        em.remove(a);
    }
}
