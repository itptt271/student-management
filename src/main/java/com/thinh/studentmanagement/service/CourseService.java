package com.thinh.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinh.studentmanagement.model.ClassSession;
import com.thinh.studentmanagement.model.Course;
import com.thinh.studentmanagement.repository.ClassSessionRepository;
import com.thinh.studentmanagement.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final ClassSessionRepository classSessionRepository;

    public CourseService(CourseRepository courseRepository, ClassSessionRepository classSessionRepository) {
        this.courseRepository = courseRepository;
        this.classSessionRepository = classSessionRepository;

    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public List<ClassSession> findSessions(Long courseId) {
        return classSessionRepository.findByCourseId(courseId);
    }
}
