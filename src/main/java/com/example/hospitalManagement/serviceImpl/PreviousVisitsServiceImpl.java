package com.example.hospitalManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.entity.PreviousVisits;
import com.example.hospitalManagement.repository.PreviousVisitsRepository;
import com.example.hospitalManagement.service.PreviousVisitsService;

@Service
public class PreviousVisitsServiceImpl implements PreviousVisitsService{
	
	@Autowired
	PreviousVisitsRepository repo;

	@Override
	public List<PreviousVisits> findAll() {
		return repo.findAll();
	}

	@Override
	public PreviousVisits findPreviousVisitsById(Integer id) {
		return repo.getById(id);
	}

}
