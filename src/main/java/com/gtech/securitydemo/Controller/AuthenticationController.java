package com.gtech.securitydemo.Controller;

import com.gtech.securitydemo.Entity.Person;
import com.gtech.securitydemo.Services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {
    private final PersonService personService;

    public AuthenticationController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody Person person){
        personService.save(person);
       return new ResponseEntity<>("Success full SignUp",HttpStatus.CREATED) ;
    }
    @GetMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>("Successfull Login",HttpStatus.OK);
    }
}
