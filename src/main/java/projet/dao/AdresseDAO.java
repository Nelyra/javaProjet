package projet.dao;

import projet.Adresse;
import java.util.List;

public interface AdresseDAO {
    public void createAdresse(Adresse a);
    public Adresse getAdresseById(int idAdresse);
    public List<Adresse> getAllAdresses();
    public void updateAdresse(Adresse a);
    public void deleteAdresse(int idAdresse);
}
