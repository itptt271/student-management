package com.thinh.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinh.studentmanagement.model.Course;
import com.thinh.studentmanagement.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
