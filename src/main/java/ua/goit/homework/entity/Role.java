package ua.goit.homework.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum Role {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private final String role;


    public static Optional<Role> getRole(String role) {
        return Arrays.stream(Role.values())
                .filter(value -> value.getRole().equals(role))
                .findAny();
    }
}
