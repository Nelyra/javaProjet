package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Etatdeslieux;

import java.util.List;

public interface EtatdeslieuxDAO {
    public void createEtatdeslieux(Etatdeslieux a);
    public Etatdeslieux getEtatdeslieuxById(int idEtatdeslieux);
    public List<Etatdeslieux> getAllEtatdeslieux();
    public void updateEtatdeslieux(Etatdeslieux a);
    public void deleteEtatdeslieux(int idEtatdeslieux);
}
