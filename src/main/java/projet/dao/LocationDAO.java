package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Location;

public interface LocationDAO {
    public void createLocation(EntityManager em, Location a);
    public Location getLocationById(EntityManager em, int idLocation);
    public void updateLocation(EntityManager em, Location a);
    public void deleteLocation(EntityManager em, int idLocation);
}
