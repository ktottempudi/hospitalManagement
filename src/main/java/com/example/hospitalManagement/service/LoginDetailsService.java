package com.example.hospitalManagement.service;

import java.util.List;

import com.example.hospitalManagement.entity.LoginDetails;

public interface LoginDetailsService {
	
	List<LoginDetails> findAll();
	LoginDetails getLoginDetailsByEmployeeId(Integer employeeId);
	void updateLogin(LoginDetails login);

}
