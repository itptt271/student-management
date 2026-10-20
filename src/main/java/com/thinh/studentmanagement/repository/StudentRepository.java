package com.thinh.studentmanagement.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thinh.studentmanagement.model.Student;

@Repository 
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        String sql = "SELECT id, student_no, name, class_name FROM students ORDER BY student_no";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new Student(
            rs.getLong("id"), 
            rs.getString("student_no"),
            rs.getString("name"),
            rs.getString("class_name")
        ));
    }
}
