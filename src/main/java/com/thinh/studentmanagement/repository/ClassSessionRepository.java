package com.thinh.studentmanagement.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thinh.studentmanagement.model.ClassSession;

@Repository
public class ClassSessionRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<ClassSession> CLASS_SESSION_ROW_MAPPER = (rs, rowNum) -> new ClassSession(
            rs.getLong("id"),
            rs.getLong("course_id"),
            rs.getInt("session_no"),
            rs.getString("date"));

    public ClassSessionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ClassSession> findByCourseId(Long courseId) {
        String sql = "SELECT id, course_id, session_no, date FROM class_sessions WHERE course_id = ? ORDER BY session_no";
        return jdbcTemplate.query(sql, CLASS_SESSION_ROW_MAPPER, courseId);
    }
}
