package com.example.SpringBasics.repositories;

import com.example.SpringBasics.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
