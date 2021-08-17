package com.example.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientDetails {
	
	@Id
	@Column(name="patiendId")
	private Integer patiendId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;

	public Integer getPatiendId() {
		return patiendId;
	}

	public void setPatiendId(Integer patiendId) {
		this.patiendId = patiendId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
