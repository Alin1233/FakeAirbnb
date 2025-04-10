package nexa.groupe.airbnb.repositories;

import nexa.groupe.airbnb.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<Users, String>, QuerydslPredicateExecutor<Users> {

    List<Users> findByFirstnameIgnoreCaseOrLastnameIgnoreCase(String firstname, String lastname);
}

