package com.example.myuniver.service;

import com.example.myuniver.model.Students;
import com.example.myuniver.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    public Students addStudent(Students student) {
        return studentRepository.save(student);
    }

    public List<Students> getStudentsByGroup(Long id) {
        return studentRepository.findByStudentsByGroup(id);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void editStudent(Long id, Students st) {
        Students student = studentRepository.findById(id).get();
    }

}
