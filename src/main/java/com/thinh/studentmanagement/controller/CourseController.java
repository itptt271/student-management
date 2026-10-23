package com.thinh.studentmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinh.studentmanagement.model.Course;
import com.thinh.studentmanagement.service.CourseService;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/api/courses")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }
}
