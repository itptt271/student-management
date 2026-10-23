package com.thinh.studentmanagement.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thinh.studentmanagement.model.Course;

@Repository
public class CourseRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Course> COURSE_ROW_MAPPER = (rs, rowNum) -> new Course(
        rs.getLong("id"),
        rs.getString("name"),
        rs.getString("teacher_name"),
        rs.getString("class_name"),
        rs.getInt("total_sessions")
    );

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Course> findAll() {
        String sql = "SELECT id, name, teacher_name, class_name, total_sessions FROM courses ORDER BY id";
        return jdbcTemplate.query(sql, COURSE_ROW_MAPPER);
    }


}
