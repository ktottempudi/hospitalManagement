package com.example.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	@Column(name="departmentId")
	private Integer departmentId;
	
	@Column(name="departmentName")
	private String departmentName;
	
	@Column(name="departmentHead")
	private String departmentHead;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

}
