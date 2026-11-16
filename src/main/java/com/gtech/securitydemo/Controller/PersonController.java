package com.gtech.securitydemo.Controller;

import com.gtech.securitydemo.Entity.Person;
import com.gtech.securitydemo.Services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
//    @GetMapping("/unlock-message")
//    public String getMessage(){
//        return "Hello World!";
//    }
    @GetMapping("/lock-message")
    public String unlockMessage(){
        return "lock message : Hello World!";
    }
}
