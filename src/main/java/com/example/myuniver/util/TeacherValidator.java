package com.example.myuniver.util;

import com.example.myuniver.model.payload.request.SignupTeacherRequest;
import com.example.myuniver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class TeacherValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignupTeacherRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignupTeacherRequest signupTeacherRequest = (SignupTeacherRequest) target;

        String regexEmail = "^[\\w]+(?:\\.[\\w]+)*@(?:[a-z0-9-]+\\.)+[\\\\a-zA-Z]{2,6}";
        Pattern patternEmail = Pattern.compile(regexEmail);

        if (!patternEmail.matcher(signupTeacherRequest.getEmail()).matches())
            errors.rejectValue("email","","Email address is invalid! Format:example@example.com");

        if (userRepository.existsByEmail(signupTeacherRequest.getEmail()))
            errors.rejectValue("email","","Email is already taken!");

        if (userRepository.existsByUsername(signupTeacherRequest.getUsername()))
            errors.rejectValue("username","","Username is already taken!");

    }
}
