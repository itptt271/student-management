package com.thinh.studentmanagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinh.studentmanagement.dto.AttendanceRequest;
import com.thinh.studentmanagement.dto.AttendanceSummary;
import com.thinh.studentmanagement.service.AttendanceService;

import jakarta.validation.Valid;

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

    @PostMapping("/api/attendance")
    public ResponseEntity<Map<String, String>> recordAttendance(@Valid @RequestBody AttendanceRequest request) {
        attendanceService.record(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "出席を登録しました"));
    }
}
