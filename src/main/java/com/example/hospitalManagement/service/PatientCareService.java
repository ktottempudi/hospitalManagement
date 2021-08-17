package com.example.hospitalManagement.service;

import java.util.List;

import com.example.hospitalManagement.entity.PatientCare;

public interface PatientCareService {

	List<PatientCare> findAll();
	PatientCare findCareByPatientId(Integer id);
	List<PatientCare> findCareByDoctorId(Integer id);
	void updateCare(PatientCare care);
}

