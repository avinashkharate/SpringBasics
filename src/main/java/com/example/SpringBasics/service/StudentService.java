package com.example.SpringBasics.service;

import com.example.SpringBasics.model.Student;
import com.example.SpringBasics.repositories.StudentRepoEntityManager;
import com.example.SpringBasics.repositories.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepoEntityManager studentRepoEntityManager;


    public StudentService( StudentRepoEntityManager studentRepoEntityManager) {
        this.studentRepoEntityManager = studentRepoEntityManager;
    }

    @Transactional
    public Student save(Student student) {
        return studentRepoEntityManager.save(student);
    }

    @Transactional
    public Student findById(Long id) {
        Student student = studentRepoEntityManager.findById(id);

        return student;
    }

    public List<Student> getAllStudent() {
        return studentRepoEntityManager.findAll();
    }


//    private final StudentRepository studentRepository;
//
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    public Student save(Student student) {
//        return studentRepository.save(student);
//    }
//
//    public Student findById(Long id) {
//        Optional<Student> student1 = studentRepository.findById(id);
//        Optional<Student> student2 = studentRepository.findById(id);
//
//        return student1.orElse(null);
//    }
}
