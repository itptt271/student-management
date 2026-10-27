package com.thinh.studentmanagement.dto;

import com.thinh.studentmanagement.model.AttendanceStatus;

import jakarta.validation.constraints.NotNull;

public record AttendanceRequest(
        @NotNull(message = "学生IDは必須です") Long studentId,

        @NotNull(message = "授業IDは必須です") Long sessionId,

        @NotNull(message = "出席状況は必須です") AttendanceStatus status) {
}