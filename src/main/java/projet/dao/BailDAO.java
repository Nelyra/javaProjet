package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Bail;

public interface BailDAO {
    public void createBail(EntityManager em, Bail a);
    public Bail getBailById(EntityManager em, int idBail);
    public void updateBail(EntityManager em, Bail a);
    public void deleteBail(EntityManager em, int idBail);
}
