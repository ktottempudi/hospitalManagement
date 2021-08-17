package com.example.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetails {
	
	@Id
	@Column(name="employeeId")
	private Integer employeeId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	/*private Set<LoginDetails> roles = new HashSet<>();
	
	public Set<LoginDetails> getRoles() {
		return roles;
	}

	public void setRoles(Set<LoginDetails> roles) {
		this.roles = roles;
	}*/

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
