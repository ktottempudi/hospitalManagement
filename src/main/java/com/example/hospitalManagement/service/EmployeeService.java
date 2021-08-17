package com.example.hospitalManagement.service;

import java.util.List;

import com.example.hospitalManagement.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findByEmployeeId(Integer id);
	Employee findByEmployeeName(String name);
	List<Employee> findEmployeeByDepartment(Integer departmentCode);
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Integer id);

}
