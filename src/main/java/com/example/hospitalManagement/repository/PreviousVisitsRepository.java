package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.entity.PreviousVisits;

@Repository
public interface PreviousVisitsRepository extends JpaRepository<PreviousVisits, Integer>{
	

}
