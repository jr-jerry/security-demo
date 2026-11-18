package com.gtech.securitydemo.Services;

import com.gtech.securitydemo.Entity.Person;
import com.gtech.securitydemo.Repo.PersonRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final PersonRepo personRepo;

    public CustomUserDetailsService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person foundPerson=personRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));

        UserDetails userDetails= User.builder()
                                .username(foundPerson.getUsername())
                                .password(foundPerson.getPassword())
                                .roles("USER")
                                .build();

        return userDetails;
    }
}
