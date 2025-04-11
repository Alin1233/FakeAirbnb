package nexa.groupe.airbnb.controllers;

import nexa.groupe.airbnb.dto.BookingCreateDTO;
import nexa.groupe.airbnb.dto.BookingFilter;
import nexa.groupe.airbnb.models.Booking;
import nexa.groupe.airbnb.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
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

    @GetMapping
    public Page<Booking> getAllBookings(
            @ModelAttribute BookingFilter filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "arrivalDate") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        return bookingService.getAllBookings(filter, pageable);
    }
}
