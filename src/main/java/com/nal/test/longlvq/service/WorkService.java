package com.nal.test.longlvq.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nal.test.longlvq.entity.Work;
import com.nal.test.longlvq.entity.WorkStatus;
import com.nal.test.longlvq.model.WorkDto;
import com.nal.test.longlvq.model.WorkStatusDto;
import com.nal.test.longlvq.repository.WorkRepository;

@Service
@Transactional
public class WorkService {
	
	@Autowired
	private WorkRepository workRepository;
	
	public Object getWorkList(int pageCurent, int rowPerpage, Sort sort){
		List<WorkDto> list = new ArrayList<WorkDto>();
//		Page<Work> page = workRepository.findAll(PageRequest.of(pageCurent - 1, rowPerpage, sort));
//		page.getContent().forEach(x -> {
//			WorkDto workDto = new WorkDto();
//			BeanUtils.copyProperties(x, workDto);
//			workDto.setWorkStatus(new WorkStatusDto());
//			BeanUtils.copyProperties(x.getWorkStatus(), workDto.getWorkStatus());
//			list.add(workDto);
//		});
		//return list;
		List<Work> lssst = workRepository.findAll();
		//lssst.forEach(x -> x.getWorkStatus().getStatusName());
	//	System.err.println(lssst.get(0).getWorkStatus().getStatusName()); 
		System.out.println(lssst.get(3).getWorkStatus());
		return lssst;
	}
}
