package com.poly.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.java6.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
