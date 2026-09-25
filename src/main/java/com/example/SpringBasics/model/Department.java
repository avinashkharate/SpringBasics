package com.example.SpringBasics.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Department")

public class Department {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depid;

    private String name;


    @OneToMany(mappedBy = "department")
    private List<Student> student;

    public Long getDepid() {
        return depid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Department{" +
                "depid=" + depid +
                ", name='" + name + '\'' +
                '}';
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }
}
