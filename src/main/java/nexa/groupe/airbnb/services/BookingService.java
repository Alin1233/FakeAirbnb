package nexa.groupe.airbnb.services;

import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityNotFoundException;
import nexa.groupe.airbnb.dto.BookingCreateDTO;
import nexa.groupe.airbnb.dto.BookingFilter;
import nexa.groupe.airbnb.models.Booking;
import nexa.groupe.airbnb.models.City;
import nexa.groupe.airbnb.models.QBooking;
import nexa.groupe.airbnb.models.Users;
import nexa.groupe.airbnb.repositories.BookingRepository;
import nexa.groupe.airbnb.repositories.CityRepository;
import nexa.groupe.airbnb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.querydsl.core.types.Predicate;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;


    @Autowired
    public BookingService(BookingRepository bookingRepository,
                          CityRepository cityRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;

    }

    @Transactional(readOnly = true)
    public Page<Booking> getAllBookings(BookingFilter filter, Pageable pageable) {
        Predicate predicate = buildPredicate(filter);
        return bookingRepository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(BookingFilter filter) {
        QBooking booking = QBooking.booking;
        BooleanBuilder builder = new BooleanBuilder();

        if (filter == null) {
            return builder.getValue();
        }

        // Title filter
        if (filter.getTitleContains() != null && !filter.getTitleContains().isEmpty()) {
            builder.and(booking.title.containsIgnoreCase(filter.getTitleContains()));
        }

        // Date range filters
        if (filter.getArrivalDateFrom() != null) {
            builder.and(booking.arrivalDate.goe(filter.getArrivalDateFrom()));
        }

        if (filter.getArrivalDateTo() != null) {
            builder.and(booking.arrivalDate.loe(filter.getArrivalDateTo()));
        }

        if (filter.getCheckoutDateFrom() != null) {
            builder.and(booking.checkoutDate.goe(filter.getCheckoutDateFrom()));
        }

        if (filter.getCheckoutDateTo() != null) {
            builder.and(booking.checkoutDate.loe(filter.getCheckoutDateTo()));
        }

        // Price range filter
        if (filter.getMinPrice() != null) {
            builder.and(booking.price.goe(filter.getMinPrice()));
        }

        if (filter.getMaxPrice() != null) {
            builder.and(booking.price.loe(filter.getMaxPrice()));
        }

        // City filter
        if (filter.getCityId() != null) {
            builder.and(booking.city.id.eq(filter.getCityId()));
        }

        // User filter
        if (filter.getUserId() != null && !filter.getUserId().isEmpty()) {
            builder.and(booking.user.id.eq(filter.getUserId()));
        }

        return builder.getValue();
    }

    public Booking createBooking(BookingCreateDTO dto) {
        Booking newBooking = new Booking();

        newBooking.setTitle(dto.title());
        newBooking.setArrivalDate(dto.arrivalDate());
        newBooking.setCheckoutDate(dto.checkoutDate());
        newBooking.setPrice(dto.price());

        City city = cityRepository.findById(String.valueOf(dto.cityId()))
                .orElseThrow(() -> new EntityNotFoundException("City not found"));
        newBooking.setCity(city);

        if (dto.userId() != null && !dto.userId().isEmpty()) {
            Users user = userRepository.findById(dto.userId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));
            newBooking.setUser(user);
        }
        return bookingRepository.save(newBooking);
    }
}


