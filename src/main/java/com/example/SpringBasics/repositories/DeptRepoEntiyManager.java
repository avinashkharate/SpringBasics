package com.example.SpringBasics.repositories;

import com.example.SpringBasics.model.Department;
import com.example.SpringBasics.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DeptRepoEntiyManager {

    @PersistenceContext
    EntityManager entityManager ;


    public Department save(Department department) {
        entityManager.persist(department);
        return department;
    }
}
