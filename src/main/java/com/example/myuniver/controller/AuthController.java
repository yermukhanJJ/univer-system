package com.example.myuniver.controller;

import com.example.myuniver.model.payload.request.SignupStudentRequest;
import com.example.myuniver.model.payload.request.SignupTeacherRequest;
import com.example.myuniver.service.RegistrationService;
import com.example.myuniver.util.StudentValidator;
import com.example.myuniver.util.TeacherValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final StudentValidator studentValidator;
    private final TeacherValidator teacherValidator;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/for-student")
    public String registrationPageForStudent(@ModelAttribute("studentRequest") SignupStudentRequest studentRequest) {
        return "auth/for-student";
    }

    @PostMapping("/for-student")
    public String registerStudent(@ModelAttribute("studentRequest") @Valid SignupStudentRequest studentRequest,
                                  BindingResult bindingResult){
        studentValidator.validate(studentRequest,bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "/auth/for-student";
        }

        registrationService.registerStudent(studentRequest);
        return "redirect:/auth/login";
    }

    @GetMapping("/for-teacher")
    public String registrationPageForTeacher(@ModelAttribute("teacherRequest") SignupTeacherRequest teacherRequest) {
        return "auth/for-teacher";
    }

    @PostMapping("/for-teacher")
    public String registerTeacher(@ModelAttribute("teacherRequest") @Valid SignupTeacherRequest teacherRequest,
                                  BindingResult bindingResult) {
        teacherValidator.validate(teacherRequest,bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "/auth/for-teacher";
        }

        registrationService.registerTeacher(teacherRequest);
        return "redirect:/auth/login";
    }
}
