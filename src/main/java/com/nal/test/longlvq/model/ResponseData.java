package com.nal.test.longlvq.model;

import lombok.Data;

@Data
public class ResponseData {

	private int status;
	private Object data;
	private String message;
	private Paging paging;
	
}
