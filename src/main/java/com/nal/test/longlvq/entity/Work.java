package com.nal.test.longlvq.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "work")
public class Work extends BaseEntity {

	@Column(name = "work_name", nullable = false)
	private String workName;


	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status_id",insertable = false, updatable = false)
	@JsonIgnoreProperties(value = "workList")
	private WorkStatus workStatus;


	public String getWorkName() {
		return workName;
	}


	public void setWorkName(String workName) {
		this.workName = workName;
	}




	public WorkStatus getWorkStatus() {
		return workStatus;
	}



	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}
	
	
}