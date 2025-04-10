package nexa.groupe.airbnb.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookingFilter {
    private String titleContains;
    private LocalDate arrivalDateFrom;
    private LocalDate arrivalDateTo;
    private LocalDate checkoutDateFrom;
    private LocalDate checkoutDateTo;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer cityId;
    private String userId;
}