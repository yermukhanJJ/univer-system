package com.example.myuniver.model.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SignupStudentRequest {

    private String username;

    private String email;

    private Set<String> role;

    private String password;

    private String surname;

    private String name;

    private String fatherland;

    private int course;

    private String telephone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bd;

}
