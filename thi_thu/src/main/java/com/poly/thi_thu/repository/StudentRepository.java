package com.poly.thi_thu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.thi_thu.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Custom query methods can be defined here if needed
}
