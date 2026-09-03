package com.example.SpringBasics.controller;

import com.example.SpringBasics.model.Student;
import com.example.SpringBasics.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing Student API endpoints.
 *
 * POST /students      → add a new student
 * GET  /students/{id} → get student by id
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Add a new student.
     * Request body: { "name": "John", "email": "john@example.com" }
     */
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student saved = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Get a student by ID.
     * Returns 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.findById(id);

        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with such Id does not exist");
        }

        return ResponseEntity.ok(student);
    }
}

