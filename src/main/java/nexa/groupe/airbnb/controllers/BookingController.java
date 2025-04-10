package nexa.groupe.airbnb.controllers;

import nexa.groupe.airbnb.dto.BookingCreateDTO;
import nexa.groupe.airbnb.models.Booking;
import nexa.groupe.airbnb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingCreateDTO input) {
        return bookingService.createBooking(input);
    }
}
