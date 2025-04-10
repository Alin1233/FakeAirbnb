package nexa.groupe.airbnb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Role {
    @Id
    private Long role_id;
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UsersRole> usersRoles;
}
