package nexa.groupe.airbnb.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookingCreateDTO(
        String title,
        LocalDate arrivalDate,
        LocalDate checkoutDate,
        BigDecimal price,
        Integer cityId,
        String userId

) {

}

