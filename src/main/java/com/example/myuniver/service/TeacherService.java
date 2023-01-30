package com.example.myuniver.service;

import com.example.myuniver.model.Teachers;
import com.example.myuniver.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teachers> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teachers createTeacher(Teachers teacher){
        return teacherRepository.save(teacher);
    }
}
