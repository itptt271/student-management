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
import com.thinh.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping("/api/students")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest request) {
        Student created = studentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}