package com.thinh.studentmanagement.dto;

public record AttendanceSummary(
        String studentNo,
        String name,
        int totalHours,
        int absentHours,
        int lateEarlyCount,
        double attendanceRate) {
}
