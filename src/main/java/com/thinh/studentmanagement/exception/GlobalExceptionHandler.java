package com.thinh.studentmanagement.exception;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (DuplicateStudentNoException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateStudentNo(DuplicateStudentNoException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                 .body(Map.of("message", e.getMessage()));
    }
}
