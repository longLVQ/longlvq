package com.nal.test.longlvq.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {
	@Id
	@GeneratedValue
    protected Long id;
}
