package com.thinh.studentmanagement.exception;

public class DuplicateAttendanceException extends RuntimeException {
    public DuplicateAttendanceException(Long studentId, Long sessionId) {
        super("この学生の出席は既に登録されています (学生ID: " + studentId + "、授業ID: " + sessionId + ") ");
    }
}
