package com.poly.thi_thu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import com.poly.thi_thu.model.Course;
import com.poly.thi_thu.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.courseRepository.findAll(pageable).getContent();
    }

    public Optional<Course> findById(int id) {
        return this.courseRepository.findById(id);
    }

    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    public void deleteById(int id) {
        this.courseRepository.deleteById(id);
    }

}
