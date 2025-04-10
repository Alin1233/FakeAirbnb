package nexa.groupe.airbnb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Booking {
    @Id
    private String id;
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date arrivalDate;
    private Date departureDate;
    private BigDecimal price;
}
