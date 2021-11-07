package ua.goit.homework.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Role;
import ua.goit.homework.entity.User;
import ua.goit.homework.entity.UserStatus;
import ua.goit.homework.repository.UserRepository;


@Service
public class UserService extends BaseService<User, Long> {

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
        user.setUserRole(Role.ROLE_ADMIN);
        user.setUserStatus (UserStatus.ACTIVE);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public void save(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException(String.format("User with specified email [%s] already exists", user.getEmail()));
        }
        user.setUserRole (user.getUserRole ());
        user.setUserStatus (user.getUserStatus ());
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save (user);
    }

}

