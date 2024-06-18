package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Bail;

public class BailDAOImpl implements BailDAO {
    @Override
    public void createBail(EntityManager em, Bail a) {
        em.persist(a);
    }
    @Override
    public Bail getBailById(EntityManager em, int idBail) {
        return em.find(Bail.class, idBail);
    }
    @Override
    public void updateBail(EntityManager em, Bail a) {
        em.merge(a);
    }
    @Override
    public void deleteBail(EntityManager em, int idBail) {
        Bail a = em.find(Bail.class, idBail);
        em.remove(a);
    }
}
