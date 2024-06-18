package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Location;

import java.util.List;

public interface LocationDAO {
    public void createLocation(EntityManager em, Location a);
    public Location getLocationById(EntityManager em, int idLocation);
    public List<Location> getAllLocations(EntityManager em);
    public void updateLocation(EntityManager em, Location a);
    public void deleteLocation(EntityManager em, int idLocation);
}
