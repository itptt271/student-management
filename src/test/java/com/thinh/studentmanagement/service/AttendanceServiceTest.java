package com.thinh.studentmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.thinh.studentmanagement.model.AttendanceCount;

class AttendanceServiceTest {

    private final AttendanceService attendanceService = new AttendanceService(null);

    @Test
    void twoLateEarlyCostNothing() {
        // Arrange: 3 buổi = 2 PRESENT + 1 ABSENT
        AttendanceCount count = new AttendanceCount(1L, "TEST001", "テスト", 3, 1, 1, 1, 0, 0);

        // Act
        int absentHours = attendanceService.calculateAbsentHours(count);

        // Assert
        assertEquals(0, absentHours);
    }
}