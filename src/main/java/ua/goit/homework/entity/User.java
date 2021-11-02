package ua.goit.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")

public class User  implements BaseEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Email(regexp = ".+@.+\\..+", message = "Email must have @ symbol")
    @Column(name = "email", nullable = false, unique = true, length = 30)
    private String email;

    @NotBlank(message = "Password can't be empty")
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @NotBlank(message = "First name can't be empty")
    @Column(name = "first_name", nullable = false, length = 15)
    private String firstName;

    @NotBlank(message = "Last name can't be empty")
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "user_role", length = 5)
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Column(name = "user_status", length = 10)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

}
