package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.entity.LoginDetails;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Integer>{
	LoginDetails getUserByUserName(String username);
}
