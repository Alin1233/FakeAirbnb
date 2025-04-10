package nexa.groupe.airbnb.services;

import jakarta.persistence.EntityNotFoundException;
import nexa.groupe.airbnb.dto.BookingCreateDTO;
import nexa.groupe.airbnb.models.Booking;
import nexa.groupe.airbnb.models.City;
import nexa.groupe.airbnb.models.Users;
import nexa.groupe.airbnb.repositories.BookingRepository;
import nexa.groupe.airbnb.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CityRepository cityRepository;


    @Autowired
    public BookingService(BookingRepository bookingRepository,
                          CityRepository cityRepository) {
        this.bookingRepository = bookingRepository;
        this.cityRepository = cityRepository;

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

//        if (dto.userId() != null && !dto.userId().isEmpty()) {
//            Users user = userRepository.findById(dto.userId())
//                    .orElseThrow(() -> new EntityNotFoundException("User not found"));
//            newBooking.setUser(user);
//        }
        //temp user
        Users user = new Users();
        newBooking.setUser(user);
        newBooking.setUser(user);
        return bookingRepository.save(newBooking);
    }
}


