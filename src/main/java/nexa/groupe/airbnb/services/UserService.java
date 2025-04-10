package nexa.groupe.airbnb.services;

import nexa.groupe.airbnb.models.Users;
import nexa.groupe.airbnb.repositories.UserRepository;
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

    public List<Users> getUsersByFirstnameOrLastname(String keyword) {
        return userRepository.findByFirstnameIgnoreCaseOrLastnameIgnoreCase(keyword, keyword);
    }

    public Optional<Users> getUserById(String id) {
        return userRepository.findById(id);
    }
}
