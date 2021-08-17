package com.example.hospitalManagement.service;

import java.util.List;

import com.example.hospitalManagement.entity.PreviousVisits;

public interface PreviousVisitsService {
	
	List<PreviousVisits> findAll();
	PreviousVisits findPreviousVisitsById(Integer id);

}
