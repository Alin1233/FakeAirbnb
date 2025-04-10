package nexa.groupe.airbnb.repositories;

import nexa.groupe.airbnb.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {
    List<Users> findByFirstnameIgnoreCaseOrLastnameIgnoreCase(String firstname, String lastname);
}
