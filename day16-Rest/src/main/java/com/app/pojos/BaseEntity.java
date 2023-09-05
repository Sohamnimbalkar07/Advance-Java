package com.app.pojos;

import javax.persistence.*;

//common super class for all entities
@javax.persistence.MappedSuperclass

public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
