package com.example.hospitalManagement.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		String rawPassword = "";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);

	}

}
