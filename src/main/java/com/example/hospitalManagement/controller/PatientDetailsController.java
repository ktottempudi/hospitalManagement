package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitalManagement.entity.PatientDetails;
import com.example.hospitalManagement.serviceImpl.PatientDetailsServiceImpl;

@Controller
public class PatientDetailsController {
	
	@Autowired
	PatientDetailsServiceImpl service;
	
	@RequestMapping(value="/getPatientDetails", method = RequestMethod.GET)
	public String getPatientDetails(Model model){
		model.addAttribute("patients", service.findAll());
		return "PatientDetails.html";
	}
	
	@RequestMapping(value="/getPatientDetailsById", method = RequestMethod.GET)
	public String getPatientDetailsById(Model model, @Param("patiendId") Integer patiendId) {
		model.addAttribute("patients", service.findDetailsById(patiendId));
		return "PatientDetails.html";
	}
	
	@RequestMapping(value="/getPatientDetailsByName", method = RequestMethod.GET)
	public String getPatientDetailsByName(Model model, @Param("name") String name) {
		model.addAttribute("patients", service.findDetailsByName(name));
		return "PatientDetails.html";
	}
	
	@RequestMapping(value="/createPatient", method = RequestMethod.POST)
	public String createPatient(@ModelAttribute("patient") PatientDetails patient) {
		service.createPatient(patient);
		return "redirect:/getPatientDetails";
	}
	
	@RequestMapping(value="/addPatient")
	public String addPatient(Model model) {
		PatientDetails patient = new PatientDetails();
		model.addAttribute("patient", patient);
		return "createPatient";
	}
	
	@RequestMapping(value="/updatePatient", method = RequestMethod.POST)
	public String updatePatient(@ModelAttribute("patient") PatientDetails patient) {
		service.updatePatient(patient);
		return "redirect:/getPatientDetails";
	}
	
	@RequestMapping("/editPatient/{id}")
	public String editPatient(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("patient", service.findDetailsById(id));
		return "updatePatient";
	}
	
	@RequestMapping(value="/deletePatient/{id}")
	public String deletePatient(@PathVariable(name = "id") Integer id) {
		service.deletePatient(id);
		return "redirect:/getPatientDetails";
	}

}
