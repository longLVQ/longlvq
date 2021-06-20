package com.nal.test.longlvq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nal.test.longlvq.entity.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long>{

}
