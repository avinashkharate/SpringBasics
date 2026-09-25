package com.example.SpringBasics.service;

import com.example.SpringBasics.model.Department;
import com.example.SpringBasics.repositories.DeptRepoEntiyManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    DeptRepoEntiyManager deptRepoEntiyManager;

    public DepartmentService(DeptRepoEntiyManager deptRepoEntiyManager)
    {
        this.deptRepoEntiyManager=deptRepoEntiyManager;
    }

    @Transactional
    public Department save(Department department)
    {
        return deptRepoEntiyManager.save(department);
    }
}
