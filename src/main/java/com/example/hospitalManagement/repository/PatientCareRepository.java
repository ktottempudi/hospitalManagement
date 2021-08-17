package com.example.hospitalManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.entity.PatientCare;

@Repository
public interface PatientCareRepository extends JpaRepository<PatientCare, Integer>{
	
	List<PatientCare> getCareByDoctorId(Integer doctorId);

}
