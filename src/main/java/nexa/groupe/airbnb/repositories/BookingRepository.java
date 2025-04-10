package nexa.groupe.airbnb.repositories;

import jakarta.persistence.criteria.Predicate;
import nexa.groupe.airbnb.models.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


public interface BookingRepository extends JpaRepository<Booking, String>, QuerydslPredicateExecutor<Booking> {
}
