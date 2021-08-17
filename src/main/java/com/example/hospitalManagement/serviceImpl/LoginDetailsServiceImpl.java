package com.example.hospitalManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.entity.LoginDetails;
import com.example.hospitalManagement.repository.LoginDetailsRepository;
import com.example.hospitalManagement.service.LoginDetailsService;

@Service
public class LoginDetailsServiceImpl implements LoginDetailsService{
	
	@Autowired
	LoginDetailsRepository repo;

	@Override
	public List<LoginDetails> findAll() {
		return repo.findAll();
	}

	@Override
	public void updateLogin(LoginDetails login) {
		repo.save(login);
	}

	@Override
	public LoginDetails getLoginDetailsByEmployeeId(Integer employeeId) {
		return repo.getById(employeeId);
	}

}
