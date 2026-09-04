package com.example.SpringBasics.repositories;

import com.example.SpringBasics.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepoEntityManager {
    @PersistenceContext
    EntityManager entityManager ;


    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student findById(Long id) {
        Student student= entityManager.find(Student.class,id);

        return student;
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}
