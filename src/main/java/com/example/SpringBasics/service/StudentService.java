package com.example.SpringBasics.service;

import com.example.SpringBasics.model.Student;
import com.example.SpringBasics.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }
}
