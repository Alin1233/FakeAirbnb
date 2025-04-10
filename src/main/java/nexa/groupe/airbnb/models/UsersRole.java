package nexa.groupe.airbnb.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UsersRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UsersRole usersRole;
}
