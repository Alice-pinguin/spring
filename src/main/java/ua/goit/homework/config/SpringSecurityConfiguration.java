package ua.goit.homework.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.goit.homework.autorization.CustomUserDetailsService;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder ();
    }

    @SneakyThrows
    @Override
    protected void configure(HttpSecurity http)  {
        http.csrf ().disable ()
                .authorizeRequests ()
                .antMatchers ("/user/registration").permitAll ()
                .anyRequest ().authenticated ()
                .and ()
                .formLogin ()
                .loginPage ("/login")
                .defaultSuccessUrl ("/")
                .permitAll ()
                .and ()
                .logout ()
                .permitAll ();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService (customUserDetailsService)
                .passwordEncoder (new BCryptPasswordEncoder ());
    }
}