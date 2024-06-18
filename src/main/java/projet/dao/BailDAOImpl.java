package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Bail;
import java.util.List;
public class BailDAOImpl implements BailDAO {
    @Override
    public void createBail(EntityManager em, Bail a) {
        em.persist(a);
    }

    @Override
    public Bail getBailById(EntityManager em, int idBail) {
        return em.find(Bail.class, idBail);
    }

    public List<Bail> getAllBails(EntityManager em) {
        return em.createQuery("SELECT a FROM Bail a", Bail.class).getResultList();
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
