package com.example.hospitalManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/getEmployees").permitAll()
			.antMatchers("/getEmployeeById/**").permitAll()
			.antMatchers("/getEmployeesByName/**").permitAll()
			.antMatchers("/createEmployee").hasAnyAuthority("ADMIN")
			.antMatchers("/addEmployee").hasAnyAuthority("ADMIN")
			.antMatchers("/edit/**").hasAnyAuthority("ADMIN")
			.antMatchers("/updateEmployee").hasAnyAuthority("ADMIN")
			.antMatchers("/deleteEmployee/**").hasAnyAuthority("ADMIN")
			.antMatchers("/getDepartments").permitAll()
			.antMatchers("/getDepartmentById/**").permitAll()
			.antMatchers("/getDepartmentByName/**").permitAll()
			.antMatchers("/createDepartment").hasAnyAuthority("ADMIN")
			.antMatchers("/addDepartment").hasAnyAuthority("ADMIN")
			.antMatchers("/editDepartment/**").hasAnyAuthority("ADMIN")
			.antMatchers("/updateDepartment").hasAnyAuthority("ADMIN")
			.antMatchers("/deleteDepartment/**").hasAnyAuthority("ADMIN")
			.antMatchers("/getLoginDetails").hasAnyAuthority("ADMIN")
			.antMatchers("/editLogin/**").hasAnyAuthority("ADMIN")
			.antMatchers("/updateLogin").hasAnyAuthority("ADMIN")
			.antMatchers("/getPatientDetails").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getDetailsById/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getDetailsByName/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/addPatient").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/createPatient").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/editPatient/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/updatePatient").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/deletePatient/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getPatientCare").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getCareById/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getCareByDoctorId/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/editPatientCare/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/updatePatientCare").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getPreviousVisits").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.antMatchers("/getPreviousVisitById/**").hasAnyAuthority("ADMIN", "MEDICAL STAFF")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll();
	}
	
	
}
