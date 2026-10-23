package com.thinh.studentmanagement.model;

public class Course {
    private Long id;
    private String name;
    private String teacherName;
    private String className;
    private int totalSessions;

    public Course(Long id, String name, String teacherName, String className, int totalSessions) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.className = className;
        this.totalSessions = totalSessions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getClassName() {
        return className;
    }

    public int getTotalSessions() {
        return totalSessions;
    }
}
