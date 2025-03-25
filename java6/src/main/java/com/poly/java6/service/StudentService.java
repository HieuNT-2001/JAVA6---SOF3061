package com.poly.java6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.poly.java6.model.Student;
import com.poly.java6.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    public Optional<Student> findById(Integer id) {
        return this.studentRepository.findById(id);
    }

    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }

}
