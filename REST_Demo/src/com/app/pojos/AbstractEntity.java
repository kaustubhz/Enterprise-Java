package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	public Integer getId() {
		return id;
	}
}
