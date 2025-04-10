package nexa.groupe.airbnb.repositories;

import nexa.groupe.airbnb.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String>, QuerydslPredicateExecutor<Users> {

    List<Users> findByFirstnameIgnoreCaseOrLastnameIgnoreCase(String firstname, String lastname);
}

