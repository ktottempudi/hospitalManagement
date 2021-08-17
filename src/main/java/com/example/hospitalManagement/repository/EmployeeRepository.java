package com.example.hospitalManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee getEmployeeByName(String name);
	List<Employee> getEmployeesByDepartment(Integer id);

}
