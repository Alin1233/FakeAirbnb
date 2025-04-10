package nexa.groupe.airbnb.controllers;

//import com.querydsl.core.types.dsl.BooleanExpression;
//import com.querydsl.core.types.Predicate;
//import nexa.groupe.airbnb.models.QUsers;
import nexa.groupe.airbnb.models.Users;
import nexa.groupe.airbnb.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public List<Users> getUsers(@RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return userService.getUsersByFirstnameOrLastname(search);
        }
        return userService.getAllUsers();
    }

//    @GetMapping
//    public Page<Users> getAllUsers(
//            @RequestParam(required = false) String firstname,
//            @RequestParam(required = false) String lastname,
//            @RequestParam(required = false) String phone,
//            Pageable pageable
//    ) {
//        QUsers qUser = QUsers.users;
//        BooleanExpression predicate = qUser.isNotNull(); // base : toujours vrai
//
//        if (firstname != null && !firstname.isEmpty()) {
//            predicate = predicate.and(qUser.firstname.containsIgnoreCase(firstname));
//        }
//
//        if (lastname != null && !lastname.isEmpty()) {
//            predicate = predicate.and(qUser.lastname.containsIgnoreCase(lastname));
//        }
//
//        if (phone != null && !phone.isEmpty()) {
//            predicate = predicate.and(qUser.phone.containsIgnoreCase(phone));
//        }
//
//        return userService.getAllUsers(pageable, predicate);
//    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable String id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }
}

