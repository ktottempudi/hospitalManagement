package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitalManagement.entity.PatientCare;
import com.example.hospitalManagement.serviceImpl.PatientCareServiceImpl;

@Controller
public class PatientCareController {
	
	@Autowired
	PatientCareServiceImpl service;
	
	@RequestMapping(value="/getPatientCare", method = RequestMethod.GET)
	public String getPatientCare(Model model){
		model.addAttribute("patients", service.findAll());
		return "PatientCare.html";
	}
	
	@RequestMapping(value="/getCareById", method = RequestMethod.GET)
	public String getCareById(Model model, @Param("patiendId") Integer patiendId) {
		model.addAttribute("patients", service.findCareByPatientId(patiendId));
		return "PatientCare.html";
	}
	
	@RequestMapping(value="/getCareByDoctor", method = RequestMethod.GET)
	public String getCareByDoctor(Model model, @Param("doctorId") Integer doctorId){
		model.addAttribute("patients", service.findCareByDoctorId(doctorId));
		return "PatientCare.html";
	}
	
	@RequestMapping(value="/editPatientCare/{id}")
	public String editPatientCare(Model model, @PathVariable(name = "id") Integer id) {
		model.addAttribute("patientCare", service.findCareByPatientId(id));
		return "updatePatientCare";
	}
	
	@RequestMapping(value="/updatePatientCare", method = RequestMethod.POST)
	public String updatePatientCare(@ModelAttribute("patientCare") PatientCare patientCare) {
		service.updateCare(patientCare);
		return "redirect:/getPatientCare";
	}

}
