package com.poly.thi_thu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.thi_thu.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom query methods can be defined here if needed

}
