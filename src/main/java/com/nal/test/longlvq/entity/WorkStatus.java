package com.nal.test.longlvq.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "work_status")
public class WorkStatus  extends BaseEntity{

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<Work> getWorkList() {
		return workList;
	}


	public void setWorkList(List<Work> workList) {
		this.workList = workList; 
	}

	@Column(name = "status_name", nullable = true)
	private String statusName;  
	
	
	@OneToMany(mappedBy = "workStatus",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "workStatus")
	private List<Work> workList;
} 
