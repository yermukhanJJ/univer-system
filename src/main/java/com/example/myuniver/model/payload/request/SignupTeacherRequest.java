package com.example.myuniver.model.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupTeacherRequest {

    @NotBlank(message = "The username fields must not be empty!")
    @Size(min = 3, max = 20,message = "The username fields must consist of a symbolic from 3 to 20")
    private String username;

    @NotBlank(message = "The email fields must not be empty!")
    private String email;

    private Set<String> role;

    @NotBlank(message = "The password fields must not be empty!")
    @Size(min = 6, max = 40, message = "The password must consist of a symbolic from 6 to 40")
    private String password;

    @NotBlank(message = "The firstname fields must not be empty!")
    private String firstname;

    @NotBlank(message = "The lastname fields must not be empty!")
    private String lastname;
}
