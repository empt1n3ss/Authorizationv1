package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Authorities;
import org.example.model.InvalidCredentials;
import org.example.model.UnauthorizedUser;
import org.example.model.User;
import org.example.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials(InvalidCredentials e){
        return e.getMessage();
    }
    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser(UnauthorizedUser e){
        System.out.println("Unauthorized access attempt: " + e.getMessage());
        return e.getMessage();
    }
}
