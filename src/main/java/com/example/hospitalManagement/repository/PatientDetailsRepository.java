package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.entity.PatientDetails;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer>{
	
	PatientDetails getDetailsByName(String name);

}
