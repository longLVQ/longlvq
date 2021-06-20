package com.nal.test.longlvq.model;

import lombok.Data;

@Data
public class Paging {
	private String sortBy;
	private Integer rowPerPage;
	private Integer page;
}
