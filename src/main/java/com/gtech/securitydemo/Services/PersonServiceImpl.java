package com.gtech.securitydemo.Services;

import com.gtech.securitydemo.Entity.Person;
import com.gtech.securitydemo.Repo.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
    @Override
    public void save(Person person) {
        personRepo.save(person);
    }
}
