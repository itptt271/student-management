package com.thinh.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinh.studentmanagement.dto.AttendanceSummary;
import com.thinh.studentmanagement.service.AttendanceService;

@RestController
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/api/attendance/summary")
    public List<AttendanceSummary> getSummaries() {
        return attendanceService.getSummaries();
    }
}
