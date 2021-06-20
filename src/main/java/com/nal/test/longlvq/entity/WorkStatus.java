package com.nal.test.longlvq.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "work_status")
@Data
public class WorkStatus extends BaseEntity {
	private Integer status;
	private String statusName; 
}
