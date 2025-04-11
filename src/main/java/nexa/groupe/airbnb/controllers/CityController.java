package nexa.groupe.airbnb.controllers;

import nexa.groupe.airbnb.dto.BookingCreateDTO;
import nexa.groupe.airbnb.models.Booking;
import nexa.groupe.airbnb.models.City;
import nexa.groupe.airbnb.services.BookingService;
import nexa.groupe.airbnb.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public City createCity(@RequestBody City input) {
        return cityService.createCity(input);
    }
}

