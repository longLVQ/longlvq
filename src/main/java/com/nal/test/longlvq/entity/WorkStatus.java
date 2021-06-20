package com.nal.test.longlvq.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "work_status")
@Data
public class WorkStatus  extends BaseEntity {

	@Column(name = "status_name", nullable = true)
	private String statusName; 
	
	@OneToMany(mappedBy = "workStatus",fetch = FetchType.EAGER)
	private List<Work> workList;
}
