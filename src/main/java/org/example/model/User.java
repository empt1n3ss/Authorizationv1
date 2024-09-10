package org.example.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    @NotEmpty(message = "Username cannot be empty")
    private String user;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

}