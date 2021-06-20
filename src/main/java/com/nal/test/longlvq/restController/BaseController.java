package com.nal.test.longlvq.restController;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import com.nal.test.longlvq.exception.ParamException;
import com.nal.test.longlvq.model.Paging;
import com.nal.test.longlvq.model.ResponseData;

import lombok.Data;

@Data
public class BaseController {
	protected ResponseData responseData = new ResponseData();
	protected Paging paging = new Paging();
	protected <T> void setDataResponse() {
		try {
			responseData.setStatus(HttpStatus.OK.value());
			responseData.setPaging(this.paging);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	protected void sortHandle(Sort sort, String sortBy) throws ParamException {
		try {
			String[] sorted = sortBy.split(" ");
			if ("ASC".equals(sorted[1])) {
				sort = Sort.by(sorted[0]);
			} else {
				sort = Sort.by(sorted[0]).descending();
			}
		} catch (Exception e) {
			throw new ParamException("sort param is not good");
		}
	}
}
