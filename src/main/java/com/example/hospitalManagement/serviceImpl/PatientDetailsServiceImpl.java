package com.example.hospitalManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.entity.PatientDetails;
import com.example.hospitalManagement.repository.PatientDetailsRepository;
import com.example.hospitalManagement.service.PatientDetailsService;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService{
	
	@Autowired
	PatientDetailsRepository repo;

	@Override
	public List<PatientDetails> findAll() {
		return repo.findAll();
	}

	@Override
	public PatientDetails findDetailsById(Integer id) {
		return repo.getById(id);
	}

	@Override
	public PatientDetails findDetailsByName(String name) {
		return repo.getDetailsByName(name);
	}

	@Override
	public void createPatient(PatientDetails patient) {
		repo.save(patient);
	}

	@Override
	public void updatePatient(PatientDetails patient) {
		repo.save(patient);
	}

	@Override
	public void deletePatient(Integer id) {
		repo.deleteById(id);
	}

}
