package com.thinh.studentmanagement.controller;

import  java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinh.studentmanagement.model.Student;
import com.thinh.studentmanagement.repository.StudentRepository;

@RestController 
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping ("/api/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
