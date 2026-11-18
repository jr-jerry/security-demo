package com.gtech.securitydemo.Services;

import com.gtech.securitydemo.Entity.Person;
import com.gtech.securitydemo.Repo.PersonRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;
    private final PasswordEncoder passwordEncoder;

    public PersonServiceImpl(PersonRepo personRepo,PasswordEncoder passwordEncoder) {
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void save(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepo.save(person);
    }
}
