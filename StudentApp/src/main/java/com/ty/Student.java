package com.ty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int sid;
	private String name;
	private String email;

	Student() {
		// Default constructor
	}

	public Student(int sid, String name, String email) {
		this.sid = sid;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", email=" + email + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
