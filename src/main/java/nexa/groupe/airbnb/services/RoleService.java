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

    public Optional<Role> getRoleById(String roleId) {
        return roleRepository.findById(roleId);
    }

    public List<Role> findByNameIgnoreCase(String name) {
        return roleRepository.findByRoleNameIgnoreCase(name);
    }

    public Optional<Role> searchRole(String query) {
        Optional<Role> byId = roleRepository.findById(query);
        if (byId.isPresent()) return byId;

        List<Role> byName = roleRepository.findByRoleNameIgnoreCase(query);
        return byName.isEmpty() ? Optional.empty() : Optional.of(byName.get(0));
    }
}
