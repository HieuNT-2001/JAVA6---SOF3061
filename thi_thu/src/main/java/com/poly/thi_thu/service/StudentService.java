package com.poly.thi_thu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.thi_thu.model.Student;
import com.poly.thi_thu.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Map<String, Object>> getAllWithCourse() {
        return this.studentRepository.getAllWithCourse();
    }

    public Page<Student> findAll(Pageable pageable) {
        return this.studentRepository.findAll(pageable);
    }

    public Optional<Student> findById(long id) {
        return this.studentRepository.findById(id);
    }

    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    public void deleteById(long id) {
        this.studentRepository.deleteById(id);
    }

}
