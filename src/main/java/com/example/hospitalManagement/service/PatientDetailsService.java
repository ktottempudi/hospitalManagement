package com.example.hospitalManagement.service;

import java.util.List;

import com.example.hospitalManagement.entity.PatientDetails;

public interface PatientDetailsService {

	List<PatientDetails> findAll();
	PatientDetails findDetailsById(Integer id);
	PatientDetails findDetailsByName(String name);
	void createPatient(PatientDetails patient);
	void updatePatient(PatientDetails patient);
	void deletePatient(Integer id);
}
