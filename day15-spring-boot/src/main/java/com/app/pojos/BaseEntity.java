package com.app.pojos;

import jakarta.persistence.GenerationType;

//common super class for all entities
@jakarta.persistence.MappedSuperclass

public class BaseEntity {
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
