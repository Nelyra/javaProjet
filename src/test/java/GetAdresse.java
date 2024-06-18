import jakarta.persistence.*;
import projet.Adresse;
import projet.dao.AdresseDAO;
import projet.dao.AdresseDAOImpl;

public class GetAdresse {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                AdresseDAO adresseDAO = new AdresseDAOImpl();

                Adresse adresse = new Adresse(  "Paris", "Rue de Paris", 1,  75000);

                adresseDAO.createAdresse(em, adresse);

                Adresse gotAdresse = adresseDAO.getAdresseById(em, 1);

                System.out.println(gotAdresse);

                //Adresse updateAdresse = new Adresse(  "Paris", "Rue de Phillipe", 1,  75000);

                //adresseDAO.updateAdresse(em, updateAdresse);

                et.commit();
            } catch (Exception e) {
                et.rollback();
                throw new RuntimeException(e);
            }
        } finally {
            if (em != null && em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }
}

