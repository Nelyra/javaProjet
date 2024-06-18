package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Bail;

import java.util.List;

public interface BailDAO {
    public void createBail(EntityManager em, Bail a);
    public Bail getBailById(EntityManager em, int idBail);
    public List<Bail> getAllBails(EntityManager em);
    public void updateBail(EntityManager em, Bail a);
    public void deleteBail(EntityManager em, int idBail);
}
