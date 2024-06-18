import jakarta.persistence.*;
import projet.Personne;

import java.util.List;

public class GetPersonneById {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poo_baux");
        final EntityManager em = emf.createEntityManager();

        try {
            final EntityTransaction et = em.getTransaction();
            try {
                et.begin();

                Query query = em.createNamedQuery("Personne.GetById");
                query.setParameter("personid", 1);

                List<Personne> listPersonnes = query.getResultList();

                System.out.println(listPersonnes.size());

                for (Personne p : listPersonnes) {
                    System.out.println(p);
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
