package com.nal.test.longlvq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nal.test.longlvq.entity.Work;
import com.nal.test.longlvq.entity.WorkStatus;

@Repository
public interface StatusRepository extends JpaRepository<WorkStatus, Long>{
	

}
