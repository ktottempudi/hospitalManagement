package com.example.hospitalManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.entity.Employee;
import com.example.hospitalManagement.repository.EmployeeRepository;
import com.example.hospitalManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}

	@Override
	public Employee findByEmployeeId(Integer id) {
		return repo.getById(id);
	}

	@Override
	public Employee findByEmployeeName(String name) {
		return repo.getEmployeeByName(name);
	}

	@Override
	public List<Employee> findEmployeeByDepartment(Integer departmentCode) {
		return repo.getEmployeesByDepartment(departmentCode);
	}

	@Override
	public void createEmployee(Employee employee) {
		repo.save(employee);	
	}

	@Override
	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}

}
