package com.example.hospitalManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.entity.PatientCare;
import com.example.hospitalManagement.repository.PatientCareRepository;
import com.example.hospitalManagement.service.PatientCareService;

@Service
public class PatientCareServiceImpl implements PatientCareService{
	
	@Autowired
	PatientCareRepository repo;

	@Override
	public List<PatientCare> findAll() {
		return repo.findAll();
	}

	@Override
	public PatientCare findCareByPatientId(Integer id) {
		return repo.getById(id);
	}

	@Override
	public List<PatientCare> findCareByDoctorId(Integer id) {
		return repo.getCareByDoctorId(id);
	}

	@Override
	public void updateCare(PatientCare care) {
		repo.save(care);
	}

}
