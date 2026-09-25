package com.example.SpringBasics.controller;

import com.example.SpringBasics.model.Department;
import com.example.SpringBasics.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService= departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        Department saved = departmentService.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }
}
