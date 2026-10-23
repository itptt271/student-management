package com.thinh.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinh.studentmanagement.dto.StudentRequest;
import com.thinh.studentmanagement.exception.DuplicateStudentNoException;
import com.thinh.studentmanagement.model.Student;
import com.thinh.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student create(StudentRequest request) {
        if (studentRepository.findByStudentNo(request.studentNo()).isPresent()) {
            throw new DuplicateStudentNoException(request.studentNo());
        }

        return studentRepository.save(
            request.studentNo(),
            request.name(),
            request.className()
        );
    }
}
