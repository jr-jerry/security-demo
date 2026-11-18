package com.gtech.securitydemo.Repo;

import com.gtech.securitydemo.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    Optional<Person> findByUsername(String name);
}
