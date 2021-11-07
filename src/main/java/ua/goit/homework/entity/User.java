package ua.goit.homework.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")

public class User  implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != null ? !id.equals (user.id) : user.id != null) return false;
        if (email != null ? !email.equals (user.email) : user.email != null) return false;
        if (password != null ? !password.equals (user.password) : user.password != null) return false;
        if (firstName != null ? !firstName.equals (user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals (user.lastName) : user.lastName != null) return false;
        if (userRole != user.userRole) return false;
        return userStatus == user.userStatus;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode () : 0;
        result = 31 * result + (email != null ? email.hashCode () : 0);
        result = 31 * result + (password != null ? password.hashCode () : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode () : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode () : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode () : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode () : 0);
        return result;
    }
}
