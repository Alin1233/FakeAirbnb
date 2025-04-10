package nexa.groupe.airbnb.controllers;

import nexa.groupe.airbnb.models.Users;
import nexa.groupe.airbnb.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Récupérer tous les utilisateurs OU rechercher par nom/prénom
    @GetMapping
    public List<Users> getUsers(@RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return userService.getUsersByFirstnameOrLastname(search);
        }
        return userService.getAllUsers();
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Création d'un user
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }
    //Update un User
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable String id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }
}

