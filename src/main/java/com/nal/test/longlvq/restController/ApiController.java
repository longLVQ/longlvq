package com.nal.test.longlvq.restController;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nal.test.longlvq.entity.WorkStatus;
import com.nal.test.longlvq.exception.ParamException;
import com.nal.test.longlvq.model.ResponseData;
import com.nal.test.longlvq.repository.StatusRepository;
import com.nal.test.longlvq.repository.UserRepository;
import com.nal.test.longlvq.repository.WorkRepository;
import com.nal.test.longlvq.service.WorkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController extends BaseController {
	
	private final WorkRepository workRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final UserRepository userRepository;
	
	private final WorkService workService;
	
	private final StatusRepository statusRepository;
	
	static {
	}

	@GetMapping("/getWord")
	public Object getAllWord(@RequestParam("page") Integer pageCurent,
			@RequestParam(name = "rowPerPage", defaultValue = "0") Integer rowPerPage,
			@RequestParam("sortBy") String sortBy) throws ParamException {
//		for (int i = 0; i < 23; i++) {
//			Work word = new Work();
//			word.setId((long) i);
//			word.setWorkName("longtst" + i);
//			word.setStartDate(LocalDate.now());
//			word.setEndDate(LocalDate.now());
//			workRepository.save(word);
//		}
//
//		User user = new User();
//		user.setUsername("longtest");
//		user.setPassword(passwordEncoder.encode("123456"));
//		userRepository.save(user);
		//System.out.println(user);
		
		Sort sort = Sort.by("id");
		sortHandle(sort, sortBy);
		
		paging.setPage(pageCurent);
		paging.setRowPerPage(rowPerPage);
		paging.setSortBy(sortBy);
		
		setDataResponse();
		responseData.setData(workService.getWorkList(pageCurent,rowPerPage,sort));	
		
		return responseData;
	}
	
	@GetMapping("/getStatus")
	public ResponseEntity<ResponseData> getAllStatus() {
		List<WorkStatus> list = statusRepository.findAll();
		responseData.setData(list);
		//list.forEach(x -> x.getWorkList().forEach(y -> y.getWorkName()));
		return new ResponseEntity<ResponseData>(responseData,HttpStatus.OK);
	}

}
