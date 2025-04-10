package nexa.groupe.airbnb.services;

import nexa.groupe.airbnb.models.Role;
import nexa.groupe.airbnb.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public List<Role> findByNameIgnoreCase(String name) {
        return roleRepository.findByNameIgnoreCase(name);
    }

    public Optional<Role> searchRole(String query) {
        try {
            Long id = Long.parseLong(query);
            return roleRepository.findById(id);
        } catch (NumberFormatException e) {
            List<Role> roles = roleRepository.findByNameIgnoreCase(query);
            return roles.isEmpty() ? Optional.empty() : Optional.of(roles.get(0));
        }
    }
}
