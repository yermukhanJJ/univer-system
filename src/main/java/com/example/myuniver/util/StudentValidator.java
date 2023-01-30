package com.example.myuniver.util;

import com.example.myuniver.model.payload.request.SignupStudentRequest;
import com.example.myuniver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class StudentValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignupStudentRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignupStudentRequest studentRequest = (SignupStudentRequest) target;

        String regexEmail = "^[\\w]+(?:\\.[\\w]+)*@(?:[a-z0-9-]+\\.)+[\\\\a-zA-Z]{2,6}";
        Pattern patternEmail = Pattern.compile(regexEmail);

        if (!patternEmail.matcher(studentRequest.getEmail()).matches())
            errors.rejectValue("email","","Email address is invalid! Format:example@example.com");

        if (userRepository.existsByEmail(studentRequest.getEmail()))
            errors.rejectValue("email","","Email is already taken!");

        if (userRepository.existsByUsername(studentRequest.getUsername()))
            errors.rejectValue("username","","Username is already taken!");

        if (studentRequest.getCourse() <= 0 && studentRequest.getCourse() > 5)
            errors.rejectValue("course","","The course fields must consist of a number from 1 to 5!");
    }
}
