package com.poly.thi_thu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
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

    public List<Student> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.studentRepository.findAll(pageable).getContent();
    }

    public Optional<Student> findById(int id) {
        return this.studentRepository.findById(id);
    }

    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    public void deleteById(int id) {
        this.studentRepository.deleteById(id);
    }

}
