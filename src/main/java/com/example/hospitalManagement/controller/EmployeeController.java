package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitalManagement.entity.Employee;
import com.example.hospitalManagement.serviceImpl.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service;
	
	@RequestMapping(value="/getEmployees", method = RequestMethod.GET)
	public String getEmployees(Model model){
		model.addAttribute("employees", service.findAll());
		return "employees.html";
	}
	
	@RequestMapping(value="/getEmployeeById", method = RequestMethod.GET)
	public String getEmployeeById(Model model, @Param("employeeId") Integer employeeId) {
		model.addAttribute("employees", service.findByEmployeeId(employeeId));
		return "employees.html";
	}
	
	@RequestMapping(value="/getEmployeeByName", method = RequestMethod.GET)
	public String getEmployeeByName(Model model, @Param("name") String name) {
		model.addAttribute("employees", service.findByEmployeeName(name));
		return "employees.html";
	}
	
	@RequestMapping(value="/createEmployee", method = RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		service.createEmployee(employee);
		return "redirect:/getEmployees";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "createEmployee";
	}
	
	@RequestMapping(value="/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		service.updateEmployee(employee);
		return "redirect:/getEmployees";
	}
	
	@RequestMapping(value="/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Integer id){
		service.deleteEmployee(id);
		return "redirect:/getEmployees";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editEmployee(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("employee", service.findByEmployeeId(id));
		return "updateEmployee";
	}

}
