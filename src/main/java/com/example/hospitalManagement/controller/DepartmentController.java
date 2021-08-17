package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitalManagement.entity.Department;
import com.example.hospitalManagement.serviceImpl.DepartmentServiceImpl;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImpl service;
	
	@RequestMapping(value="/getDepartments", method = RequestMethod.GET)
	public String getDepartments(Model model){
		model.addAttribute("departments", service.findAll());
		return "departments.html";
	}
	
	@RequestMapping(value="/getDepartmentById", method = RequestMethod.GET)
	public String getDepartmentById(Model model, @Param("departmentId") Integer departmentId) {
		model.addAttribute("departments", service.findDepartmentById(departmentId));
		return "departments.html";
	}
	
	@RequestMapping(value="/getDepartmentByName", method = RequestMethod.GET)
	public String getDepartmentByName(Model model, @Param("departmentName") String departmentName) {
		model.addAttribute("departments", service.findDepartmentByDepartmentName(departmentName));
		return "departments.html";
	}
	
	@RequestMapping(value="/createDepartment", method = RequestMethod.POST)
	public String createDepartment(@ModelAttribute("department") Department department) {
		service.createDepartment(department);
		return "redirect:/getDepartments";
	}
	
	@RequestMapping("/addDepartment")
	public String addDepartment(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return "createDepartment";
	}
	
	@RequestMapping(value="/updateDepartment", method = RequestMethod.POST)
	public String updateDepartment(@ModelAttribute("department") Department department) {
		service.updateDepartment(department);
		return "redirect:/getDepartments";
	}
	
	@RequestMapping(value="/editDepartment/{id}")
	public String editDepartment(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("department", service.findDepartmentById(id));
		return "updateDepartment";
	}
	
	@RequestMapping(value="/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable(name = "id") Integer id) {
		service.deleteDepartment(id);
		return "redirect:/getDepartments";
	}

}
