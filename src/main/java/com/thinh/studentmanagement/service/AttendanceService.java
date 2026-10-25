package com.thinh.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinh.studentmanagement.model.AttendanceCount;
import com.thinh.studentmanagement.repository.AttendanceRepository;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private static final int LATE_COUNT_PER_DEDUCTION = 3;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<AttendanceCount> findCountsByStudent() {
        return attendanceRepository.findCountsByStudent();
    }

    public int calculateAttendedSessions(AttendanceCount count) {
        int lateDeduction = count.lateCount() / LATE_COUNT_PER_DEDUCTION;
        return count.presentCount() + count.officialAbsenceCount() + count.lateCount() - lateDeduction;
    }

    public double calculateAttendanceRate(int attendedSessions, int totalSessions) {
        if (totalSessions == 0) {
            return 0.0;
        }

        double rate = (double) attendedSessions / totalSessions * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
