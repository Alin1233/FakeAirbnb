package nexa.groupe.airbnb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
