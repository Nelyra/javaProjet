import jakarta.persistence.*;
import projet.Adresse;
import projet.dao.AdresseDAO;
import projet.dao.AdresseDAOImpl;

import java.util.List;

public class GetAdresse {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                AdresseDAO adresseDAO = new AdresseDAOImpl();

                List<Adresse> a = adresseDAO.getAllAdresses(em);

                System.out.println("Liste des adresses :");
                for (Adresse adresse : a) {
                    System.out.println(adresse);
                }

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

