package ua.goit.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Role;
import ua.goit.homework.entity.User;
import ua.goit.homework.repository.UserRepository;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<User, UUID> {

    private final UserRepository repository;

    private final BCryptPasswordEncoder encoder;

    public UserRepository getRepository() {
        return repository;
    }

    public User saveUser(User user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException (String.format("User with specified email [%s] already exists",
                    user.getEmail()));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    }

