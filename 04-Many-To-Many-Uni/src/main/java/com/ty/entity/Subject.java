package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	private Integer id;
	private String name;
	private Integer days;

	public Subject(Integer id, String name, Integer days) {
		this.id = id;
		this.name = name;
		this.days = days;
	}

	Subject() {
		// Default constructor
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

}
