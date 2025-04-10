package nexa.groupe.airbnb.services;

import com.querydsl.core.types.Predicate;
import nexa.groupe.airbnb.models.Users;
import nexa.groupe.airbnb.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Page<Users> getAllUsers(Pageable pageable, Predicate predicate) {
        return userRepository.findAll(predicate, pageable);
    }

    public List<Users> getUsersByKeyword(String keyword) {
        return userRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrPhoneContainingIgnoreCase(
                keyword, keyword, keyword);
    }

    public Optional<Users> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(String id, Users updatedUser) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setFirstname(updatedUser.getFirstname());
        existingUser.setLastname(updatedUser.getLastname());
        existingUser.setPhone(updatedUser.getPhone());

        return userRepository.save(existingUser);
    }
}
