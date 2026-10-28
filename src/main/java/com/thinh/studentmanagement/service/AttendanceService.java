package com.thinh.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thinh.studentmanagement.dto.AttendanceRequest;
import com.thinh.studentmanagement.dto.AttendanceSummary;
import com.thinh.studentmanagement.exception.DuplicateAttendanceException;
import com.thinh.studentmanagement.exception.ResourceNotFoundException;
import com.thinh.studentmanagement.model.AttendanceCount;
import com.thinh.studentmanagement.repository.AttendanceRepository;



@Service
public class AttendanceService {

    private static final int HOURS_PER_SESSION = 2;
    private static final int LATE_EARLY_COUNT_PER_ABSENCE = 3;

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<AttendanceSummary> getSummaries() {
        List<AttendanceCount> counts = attendanceRepository.findCountsByStudent();
        List<AttendanceSummary> summaries = new ArrayList<>();

        for (AttendanceCount count : counts) {
            int totalHours = count.total() * HOURS_PER_SESSION;
            int absentHours = calculateAbsentHours(count);
            double rate = calculateAttendanceRate(totalHours - absentHours, totalHours);

            summaries.add(new AttendanceSummary(
                    count.studentNo(),
                    count.name(),
                    totalHours,
                    absentHours,
                    count.lateCount() + count.earlyLeaveCount(),
                    rate));
        }

        return summaries;
    }

    public void record(AttendanceRequest request) {
        if (!attendanceRepository.studentExists(request.studentId())) {
            throw new ResourceNotFoundException("指定された学生が見つかりません");
        }

        if (!attendanceRepository.sessionExists(request.sessionId())) {
            throw new ResourceNotFoundException("指定された授業が見つかりません");
        }

        if (attendanceRepository.exists(request.studentId(), request.sessionId())) {
            throw new DuplicateAttendanceException(request.studentId(), request.sessionId());
        }

        attendanceRepository.save(request.studentId(), request.sessionId(), request.status());
    }

    public int calculateAbsentHours(AttendanceCount count) {
        int lateEarlyCount = count.lateCount() + count.earlyLeaveCount();
        int absentSessions = count.absentCount() + lateEarlyCount / LATE_EARLY_COUNT_PER_ABSENCE;
        return absentSessions * HOURS_PER_SESSION;
    }

    public double calculateAttendanceRate(int attendedHours, int totalHours) {
        if (totalHours == 0) {
            return 0.0;
        }

        double rate = (double) attendedHours / totalHours * 100;
        return Math.round(rate * 10) / 10.0;
    }
}