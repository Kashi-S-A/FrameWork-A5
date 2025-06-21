package com.ty.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	private Integer id;
	private String name;
	private Integer days;

	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;

	public Subject(Integer id, String name, Integer days) {
		this.id = id;
		this.name = name;
		this.days = days;
	}

	Subject() {
		// Default constructor
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
