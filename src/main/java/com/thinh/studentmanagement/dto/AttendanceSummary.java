package com.thinh.studentmanagement.dto;

public record AttendanceSummary(
    String studentNo,
    String name,
    int totalSessions,
    int attendedSessions,
    int lateCount,
    double attendanceRate
) {
}
