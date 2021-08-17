package com.example.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PreviousVisits {
	
	@Id
	@Column(name="patientId")
	private Integer patientId;
	
	@Column(name="reasonForVisits")
	private String reasonForVisits;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getReasonForVisits() {
		return reasonForVisits;
	}

	public void setReasonForVisits(String reasonForVisits) {
		this.reasonForVisits = reasonForVisits;
	}

}
