package nexa.groupe.airbnb.repositories;

import nexa.groupe.airbnb.models.Booking;
import nexa.groupe.airbnb.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
