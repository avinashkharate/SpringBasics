package com.example.SpringBasics.service;

import com.example.SpringBasics.model.Student;
import com.example.SpringBasics.repositories.StudentRepository;

import java.util.Optional;

public class StudentService {

    StudentRepository studentRepository;

    public Student save(Student student){
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public Student findById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);

    }
}
