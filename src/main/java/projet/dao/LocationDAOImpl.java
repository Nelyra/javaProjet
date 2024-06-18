package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Location;

import java.util.List;

public class LocationDAOImpl implements LocationDAO {
    @Override
    public void createLocation(EntityManager em, Location a) {
        em.persist(a);
    }

    @Override
    public Location getLocationById(EntityManager em, int idLocation) {
        return em.find(Location.class, idLocation);
    }

    @Override
    public List<Location> getAllLocations(EntityManager em) {
        return em.createQuery("SELECT a FROM Location a", Location.class).getResultList();
    }

    @Override
    public void updateLocation(EntityManager em, Location a) {
        em.merge(a);
    }

    @Override
    public void deleteLocation(EntityManager em, int idLocation) {
        Location a = em.find(Location.class, idLocation);
        em.remove(a);
    }
}
