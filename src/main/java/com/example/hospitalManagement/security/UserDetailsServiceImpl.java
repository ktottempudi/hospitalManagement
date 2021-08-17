package com.example.hospitalManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.hospitalManagement.entity.LoginDetails;
import com.example.hospitalManagement.repository.LoginDetailsRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	LoginDetailsRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDetails user = repo.getUserByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not find userName");
		}
		return new MyUserDetails(user);
	}

}
