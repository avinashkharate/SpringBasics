package com.example.SpringBasics.dao;

import com.example.SpringBasics.model.Student;
import com.example.SpringBasics.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Data Access Object for Student using plain Hibernate Session API.
 * No JPA EntityManager or Spring Data Repository is used here.
 */
@Repository
public class StudentDao {

    private final SessionFactory sessionFactory;

    public StudentDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Persists a new Student record and returns the saved entity (with generated id).
     * Session is managed manually so commit happens before the session is closed.
     */
    public Student save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(student);   // plain Hibernate persist
            transaction.commit();
            return student;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save student", e);
        } finally {
            session.close();
        }
    }

    /**
     * Retrieves a Student by its primary key.
     * Returns null if not found.
     */
    public Student findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);  // plain Hibernate get
        }
    }
}
