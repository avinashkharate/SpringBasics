package com.example.SpringBasics.model;

import jakarta.persistence.*;

/**
 * Represents extra profile details for a Student.
 *
 * ONE-TO-ONE (Owned/Inverse side):
 *   - This entity holds NO foreign key.
 *   - The FK lives in the STUDENTS table (profile_id column).
 *   - Student is the OWNING side via @JoinColumn.
 */
@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    private String phone;

    private String address;

    @OneToOne(mappedBy = "profile")
    private Student student;

    public StudentProfile(Long id, String bio, String phone, String address, Student student) {
        this.id = id;
        this.bio = bio;
        this.phone = phone;
        this.address = address;
        this.student = student;
    }

    public StudentProfile (){
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

}
