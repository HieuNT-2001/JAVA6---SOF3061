package com.poly.thi_thu.service;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.poly.thi_thu.model.Course;
import com.poly.thi_thu.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Page<Course> findAll(Pageable pageable) {
        return this.courseRepository.findAll(pageable);
    }

    public Optional<Course> findById(long id) {
        return this.courseRepository.findById(id);
    }

    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    public void deleteById(long id) {
        this.courseRepository.deleteById(id);
    }

}
