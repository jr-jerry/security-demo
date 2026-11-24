package com.gtech.securitydemo.Controller;

import com.gtech.securitydemo.Entity.Person;
import com.gtech.securitydemo.Services.AuthService;
import com.gtech.securitydemo.Services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {
    public AuthenticationController(AuthService authService, PersonService personService) {
        this.authService = authService;
        this.personService = personService;
    }

    private final AuthService authService;
    private final PersonService personService;


    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody Person person){
        personService.save(person);
       return new ResponseEntity<>("Success full SignUp",HttpStatus.CREATED) ;
    }
    @GetMapping("/login")
    public ResponseEntity<Map<String,String>> login(){

        String access_token=authService.userLogin();
        Map<String,String> map=Map.of("access_token",access_token);
        // return that access-token to user
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
