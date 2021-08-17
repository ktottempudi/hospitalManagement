package com.example.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientCare {
	
	@Id
	@Column(name="patiendId")
	private Integer patiendId;
	
	@Column(name="reason")
	private String reason;
	
	@Column(name="doctorId")
	private Integer doctorId;

	public Integer getPatiendId() {
		return patiendId;
	}

	public void setPatiendId(Integer patiendId) {
		this.patiendId = patiendId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

}
