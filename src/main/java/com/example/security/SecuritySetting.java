package com.example.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecuritySetting {


    @Bean
    public UserDetailsService userDetailsService (PasswordEncoder passwordEncoder) {
        UserDetails userDetails = User.withUsername("roman")
                .password(passwordEncoder.encode("rcua93210"))
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity security)  {
        return security.csrf().disable()
                .authorizeRequests()
                .antMatchers("/hello", "/login").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }

}
