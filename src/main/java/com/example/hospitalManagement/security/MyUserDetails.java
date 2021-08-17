package com.example.hospitalManagement.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.hospitalManagement.entity.LoginDetails;

public class MyUserDetails implements UserDetails{
	
	private LoginDetails employeeLogin;
	
	public MyUserDetails(LoginDetails employee) {
		this.employeeLogin = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Set<LoginDetails> roles = this.employeeLogin.getRoles();
		//List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		/*for(LoginDetails role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}*/
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(employeeLogin.getRole()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return employeeLogin.getPassword();
	}

	@Override
	public String getUsername() {
		return employeeLogin.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
