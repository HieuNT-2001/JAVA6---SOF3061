package com.poly.thi_thu.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.thi_thu.model.Student;
import com.poly.thi_thu.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/with-course")
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        List<Map<String, Object>> items = studentService.getAllWithCourse();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Student> items = studentService.findAll(pageable);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") long id) {
        Optional<Student> existingItemOptional = studentService.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody @Valid Student item) {
        Student savedItem = studentService.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
