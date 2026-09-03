package com.example.SpringBasics.controller;

import com.example.SpringBasics.dao.StudentDao;
import com.example.SpringBasics.model.Student;
import com.example.SpringBasics.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private StudentService studentService;


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

        return ResponseEntity.ok(student);
    }
}
