package nexa.groupe.airbnb.repositories;

import nexa.groupe.airbnb.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, String> {
    List<Role> findByRoleNameIgnoreCase(String roleName);
}
