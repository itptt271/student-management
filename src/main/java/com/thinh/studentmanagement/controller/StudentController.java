package com.thinh.studentmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinh.studentmanagement.dto.StudentRequest;
import com.thinh.studentmanagement.model.Student;
import com.thinh.studentmanagement.repository.StudentRepository;

import jakarta.validation.Valid;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/api/students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest request) {
        Student created = studentRepository.save (
            request.studentNo(),
            request.name(),
            request.className()
        );
        return  ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
