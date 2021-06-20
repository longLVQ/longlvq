package com.nal.test.longlvq.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "work")
@Data
public class Work extends BaseEntity {

	@Column(name = "work_name", nullable = false)
	private String workName;

	@Column(name = "start_date", nullable = true)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = true)
	private LocalDate endDate;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="status_id",insertable = false, updatable = false)
	private WorkStatus workStatus;
}