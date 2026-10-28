package com.thinh.studentmanagement.model;

public record ClassSession(
    Long id,
    Long courseId,
    int sessionNo,
    String date
) {
}
