package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Location;

public class LocationDAOImpl implements LocationDAO {
    public void createLocation(EntityManager em, Location a) {
        em.persist(a);
    }

    public Location getLocationById(EntityManager em, int idLocation) {
        return em.find(Location.class, idLocation);
    }

    public void updateLocation(EntityManager em, Location a) {
        em.merge(a);
    }

    public void deleteLocation(EntityManager em, int idLocation) {
        Location a = em.find(Location.class, idLocation);
        em.remove(a);
    }
}
