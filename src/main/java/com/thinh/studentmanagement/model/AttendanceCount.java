package com.thinh.studentmanagement.model;

public record AttendanceCount(
        Long studentId,
        String studentNo,
        String name,
        int total,
        int presentCount,
        int lateCount,
        int earlyLeaveCount,
        int absentCount,
        int officialAbsenceCount
) {
}