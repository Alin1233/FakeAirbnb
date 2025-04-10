package nexa.groupe.airbnb.controllers;

import nexa.groupe.airbnb.models.Role;
import nexa.groupe.airbnb.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/search")
    public Optional<Role> searchRole(@RequestParam String query) {
        return roleService.searchRole(query);
    }

    @GetMapping("/{roleId}")
    public Optional<Role> getRoleById(@PathVariable String roleId) {
        return roleService.getRoleById(roleId);
    }
}
