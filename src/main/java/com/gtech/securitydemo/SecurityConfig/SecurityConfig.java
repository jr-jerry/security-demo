package com.gtech.securitydemo.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       return http.authorizeHttpRequests(
                authorizeRequests ->
                        authorizeRequests.requestMatchers(HttpMethod.POST,"/api/authenticate/signUp").permitAll()
                                .requestMatchers("/h2-console/*").permitAll()
                                .anyRequest().authenticated()
               )
               .cors(cors->cors.disable())
               .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .build();

    }
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }
}
