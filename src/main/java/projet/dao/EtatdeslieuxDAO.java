package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Etatdeslieux;

public interface EtatdeslieuxDAO {
    public void createEtatdeslieux(EntityManager em, Etatdeslieux a);
    public Etatdeslieux getEtatdeslieuxById(EntityManager em, int idEtatdeslieux);
    public void updateEtatdeslieux(EntityManager em, Etatdeslieux a);
    public void deleteEtatdeslieux(EntityManager em, int idEtatdeslieux);
}
