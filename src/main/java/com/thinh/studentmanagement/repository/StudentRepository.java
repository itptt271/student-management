package com.thinh.studentmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thinh.studentmanagement.model.Student;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Student> STUDENT_ROW_MAPPER = (rs, rowNum) -> new Student(
            rs.getLong("id"),
            rs.getString("student_no"),
            rs.getString("name"),
            rs.getString("class_name")
    );

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        String sql = "SELECT id, student_no, name, class_name FROM students ORDER BY student_no";
        return jdbcTemplate.query(sql, STUDENT_ROW_MAPPER);
    }

    public Optional<Student> findByStudentNo(String studentNo) {
        String sql = "SELECT id, student_no, name, class_name FROM students WHERE student_no = ?";
        return jdbcTemplate.query(sql, STUDENT_ROW_MAPPER, studentNo)
                .stream()
                .findFirst();
    }

    public Student save(String studentNo, String name, String className) {
        String sql = "INSERT INTO students (student_no, name, class_name) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, studentNo, name, className);
        return findByStudentNo(studentNo).orElseThrow();
    }
}