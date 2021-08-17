package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hospitalManagement.serviceImpl.PreviousVisitsServiceImpl;

@Controller
public class PreviousVisitsController {
	
	@Autowired
	PreviousVisitsServiceImpl service;
	
	@RequestMapping(value="/getPreviousVisits", method = RequestMethod.GET)
	public String getPreviousVisits(Model model){
		model.addAttribute("histories", service.findAll());
		return "PatientHistory.html";
	}
	
	@RequestMapping(value="/getPreviousVisitsById", method = RequestMethod.GET)
	public String getVisitById(Model model, @Param("patiendId") Integer patiendId) {
		model.addAttribute("histories", service.findPreviousVisitsById(patiendId));
		return "PatientHistory.html";
	}

}
