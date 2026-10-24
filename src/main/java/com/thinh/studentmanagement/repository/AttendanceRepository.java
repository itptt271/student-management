package com.thinh.studentmanagement.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.thinh.studentmanagement.model.AttendanceCount;

@Repository
public class AttendanceRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<AttendanceCount> ATTENDANCE_COUNT_ROW_MAPPER = (rs, rowNum) -> new AttendanceCount(
            rs.getLong("student_id"),
            rs.getString("student_no"),
            rs.getString("name"),
            rs.getInt("total"),
            rs.getInt("present_count"),
            rs.getInt("late_count"),
            rs.getInt("early_leave_count"),
            rs.getInt("absent_count"),
            rs.getInt("official_absence_count"));

    public AttendanceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AttendanceCount> findCountsByStudent() {
        String sql = """
                SELECT student_id, students.student_no, students.name,
                COUNT(*) AS total,
                SUM(CASE WHEN status = 'PRESENT' THEN 1 ELSE 0 END) AS present_count,
                SUM(CASE WHEN status = 'LATE' THEN 1 ELSE 0 END) AS late_count,
                SUM(CASE WHEN status = 'EARLY_LEAVE' THEN 1 ELSE 0 END) AS early_leave_count,
                SUM(CASE WHEN status = 'ABSENT' THEN 1 ELSE 0 END) AS absent_count,
                SUM(CASE WHEN status = 'OFFICIAL_ABSENCE' THEN 1 ELSE 0 END) AS official_absence_count
                FROM attendance
                JOIN students ON attendance.student_id = students.id
                GROUP BY student_id, students.student_no, students.name
                """;
        return jdbcTemplate.query(sql, ATTENDANCE_COUNT_ROW_MAPPER);
    }
}
