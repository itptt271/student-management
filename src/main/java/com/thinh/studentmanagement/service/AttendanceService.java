package com.thinh.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thinh.studentmanagement.dto.AttendanceSummary;
import com.thinh.studentmanagement.model.AttendanceCount;
import com.thinh.studentmanagement.repository.AttendanceRepository;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private static final int LATE_COUNT_PER_DEDUCTION = 3;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<AttendanceSummary> getSummaries() {
        List<AttendanceCount> counts = attendanceRepository.findCountsByStudent();
        List<AttendanceSummary> summaries = new ArrayList<>();

        for (AttendanceCount count : counts) {
            int attended = calculateAttendedSessions(count);
            double rate = calculateAttendanceRate(attended, count.total());
            summaries.add(new AttendanceSummary(
                count.studentNo(),
                count.name(),
                count.total(),
                attended,
                count.lateCount(),
                rate
            ));
        }
        return summaries;
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
