package projet.dao;

import jakarta.persistence.EntityManager;
import projet.Location;

import java.util.List;

public interface LocationDAO {
    public void createLocation(Location a);
    public Location getLocationById(int idLocation);
    public List<Location> getAllLocations();
    public void updateLocation(Location a);
    public void deleteLocation(int idLocation);
}
