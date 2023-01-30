package com.example.myuniver.service;

import com.example.myuniver.model.*;
import com.example.myuniver.model.payload.request.SignupStudentRequest;
import com.example.myuniver.model.payload.request.SignupTeacherRequest;
import com.example.myuniver.repository.RoleRepository;
import com.example.myuniver.repository.StudentRepository;
import com.example.myuniver.repository.TeacherRepository;
import com.example.myuniver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Transient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transient
public class RegistrationService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public void registerStudent(SignupStudentRequest studentRequest) {
        // Create new student's account
        Set<String> strRoles = studentRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "teacher":
                        Role tRole = roleRepository.findByName(ERole.ROLE_TEACHER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(tRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        Users user = new Users(studentRequest.getUsername(),
                studentRequest.getEmail(),
                encoder.encode(studentRequest.getPassword()));

        Students student = new Students(studentRequest.getSurname(), studentRequest.getName(),
                studentRequest.getFatherland(), studentRequest.getUsername(),
                studentRequest.getCourse(), studentRequest.getTelephone(), studentRequest.getBd()
        );

        user.setRoles(roles);
        userRepository.save(user);
        studentRepository.save(student);
    }

    public void registerTeacher(SignupTeacherRequest teacherRequest) {
        // Create new teacher's account
        Set<String> strRoles = teacherRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_TEACHER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "student":
                        Role stRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(stRole);

                        break;
                    default:
                        Role tRole = roleRepository.findByName(ERole.ROLE_TEACHER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(tRole);
                }
            });
        }
        Users user = new Users(teacherRequest.getUsername(),
                teacherRequest.getEmail(),
                encoder.encode(teacherRequest.getPassword()));

        Teachers teacher = new Teachers(teacherRequest.getFirstname(), teacherRequest.getLastname(),
                teacherRequest.getUsername()
        );

        user.setRoles(roles);



        userRepository.save(user);
        teacherRepository.save(teacher);
    }
}
