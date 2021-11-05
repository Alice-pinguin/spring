package ua.goit.homework.autorization;

import java.io.Serial;
import java.util.Collection;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.User;
import ua.goit.homework.entity.UserStatus;
import ua.goit.homework.repository.UserRepository;

@RequiredArgsConstructor
@Service(value = "userServiceDetails")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user with username %s not exists", email)));
        return new UserDetails() {

            @Serial
            private static final long serialVersionUID = -738565735037431772L;

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {

                return Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().toString()));
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return user.getUserStatus()==UserStatus.ACTIVE;
            }

        };
    }

}
