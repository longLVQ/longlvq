package com.nal.test.longlvq.restController;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.nal.test.longlvq.model.Paging;
import com.nal.test.longlvq.model.ResponseData;

import lombok.Data;

@Data
public class BaseController {
	protected ResponseData responseData = new ResponseData();
	protected Paging paging = new Paging();
	protected <T> void setDataResponse(Page<T> paging) {
		try {
			responseData.setStatus(HttpStatus.OK.value());
			responseData.setData(paging.getContent());
			responseData.setPaging(this.paging);
		} catch (Exception e) {
			throw e;
		}
		
	}
}
