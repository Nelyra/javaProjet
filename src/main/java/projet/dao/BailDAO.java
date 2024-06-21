package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Bail;

import java.util.List;

public interface BailDAO {
    public void createBail(Bail a);
    public Bail getBailById(int idBail);
    public List<Bail> getAllBails();
    public void updateBail(Bail a);
    public void deleteBail(int idBail);
}
