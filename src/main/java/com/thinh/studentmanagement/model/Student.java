package com.thinh.studentmanagement.model;

public class Student {
    private Long id;
    private String studentNo;
    private String name;
    private String className;

    public Student(Long id, String studentNo, String name, String className) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getClassName() { 
        return className;
    }
}
