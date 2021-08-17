package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	Department getDepartmentByDepartmentName(String name);

}
