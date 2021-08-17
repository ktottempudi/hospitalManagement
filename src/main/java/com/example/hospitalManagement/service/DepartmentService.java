package com.example.hospitalManagement.service;

import java.util.List;

import com.example.hospitalManagement.entity.Department;

public interface DepartmentService {

	List<Department> findAll();
	Department findDepartmentById(Integer Id);
	Department findDepartmentByDepartmentName(String name);
	void createDepartment(Department dept);
	void updateDepartment(Department dept);
	void deleteDepartment(Integer id);
}
