package com.nal.test.longlvq.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WorkDto {
	private Long id;
	private String workName;

	private LocalDate startDate;

	private LocalDate endDate;
	

	private WorkStatusDto workStatus = new WorkStatusDto();
}
