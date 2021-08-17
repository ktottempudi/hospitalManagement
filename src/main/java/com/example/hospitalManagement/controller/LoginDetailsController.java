package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitalManagement.entity.LoginDetails;
import com.example.hospitalManagement.serviceImpl.LoginDetailsServiceImpl;

@Controller
public class LoginDetailsController {
	
	@Autowired
	LoginDetailsServiceImpl service;
	
	@RequestMapping(value="/getLoginDetails", method = RequestMethod.GET)
	public String getLoginDetails(Model model){
		model.addAttribute("credentials", service.findAll());
		return "LoginDetails.html";
	}
	
	@RequestMapping(value="/getUserById", method = RequestMethod.GET)
	public String getUserById(Model model, @Param("employeeId") Integer employeeId) {
		model.addAttribute("credentials", service.getLoginDetailsByEmployeeId(employeeId));
		return "LoginDetails.html";
	}
	
	@RequestMapping(value="/editLogin/{id}")
	public String editLogin(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("loginDetails", service.getLoginDetailsByEmployeeId(id));
		return "updateLogin";
	}
	
	@RequestMapping(value="/updateLogin", method = RequestMethod.POST)
	public String updateLogin(@ModelAttribute("loginDetails") LoginDetails loginDetails) {
		String password = loginDetails.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		loginDetails.setPassword(encodedPassword);
		service.updateLogin(loginDetails);
		return "redirect:/getLoginDetails";
	}
	
}
