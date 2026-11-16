package com.gtech.securitydemo.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
     public UserDetailsService daoAuthenticationProvider() {

        UserDetails customUserDetailsObj=new User("Gautam",
                passwordEncoder().encode("gautam"),
                List.of());
        return new InMemoryUserDetailsManager(customUserDetailsObj);
    }
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }
}
