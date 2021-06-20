package com.nal.test.longlvq.restController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nal.test.longlvq.entity.Work;
import com.nal.test.longlvq.exception.ParamException;
import com.nal.test.longlvq.model.ResponseData;
import com.nal.test.longlvq.repository.WorkRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController extends BaseController {
	
	private final WorkRepository workRepository;
	
	static {
	}

	@GetMapping("/getWord")
	public ResponseEntity<ResponseData> getAllWord(@RequestParam("page") Integer pageCurent,
			@RequestParam(name = "rowPerPage", defaultValue = "0") Integer rowPerPage,
			@RequestParam("sortBy") String sortBy) throws ParamException {
//		for (int i = 0; i < 23; i++) {
//			Work word = new Work();
//			word.setId((long) i);
//			word.setWorkName("longtst");
//			workRepository.save(word);
//		}

//		User user = new User();
//		user.setUsername("longtest");
//		user.setPassword(passwordEncoder.encode("123456"));
//		userRepository.save(user);
//		System.out.println(user);
		Sort sort;
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
		Page<Work> page = workRepository.findAll(PageRequest.of(pageCurent - 1, rowPerPage, sort));
		paging.setPage(pageCurent);
		paging.setRowPerPage(rowPerPage);
		paging.setSortBy(sortBy);
		setDataResponse(page);
		
		return new ResponseEntity<ResponseData>(responseData,HttpStatus.OK) ;
	}

}
