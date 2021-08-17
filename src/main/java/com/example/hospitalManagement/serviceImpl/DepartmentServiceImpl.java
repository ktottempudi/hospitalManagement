package com.example.hospitalManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.entity.Department;
import com.example.hospitalManagement.repository.DepartmentRepository;
import com.example.hospitalManagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository repo;

	@Override
	public List<Department> findAll() {
		return repo.findAll();
	}

	@Override
	public Department findDepartmentById(Integer Id) {
		return repo.getById(Id);
	}

	@Override
	public Department findDepartmentByDepartmentName(String name) {
		return repo.getDepartmentByDepartmentName(name);
	}

	@Override
	public void createDepartment(Department dept) {
		repo.save(dept);
	}

	@Override
	public void updateDepartment(Department dept) {
		repo.save(dept);
	}

	@Override
	public void deleteDepartment(Integer id) {
		repo.deleteById(id);
		
	}

}
