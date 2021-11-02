package ua.goit.homework.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Role;
import ua.goit.homework.entity.User;
import ua.goit.homework.repository.UserRepository;
import java.util.UUID;

@Service
public class UserService extends BaseService<User, UUID> {

    private final UserRepository repository;

    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder encoder) {
        super(repository);
        this.repository = repository;
        this.encoder = encoder;
    }

    public void register(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Account with provided email already exists");
        }
        user.setUserRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public User save(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException(String.format("User with specified email [%s] already exists", user.getEmail()));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

}

