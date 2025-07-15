package com.sb.util;

public class Student {

	private Integer sid;
	private String name;
	private String email;

	public Student() {
	}

	public Student(Integer sid, String name, String email) {
		this.sid = sid;
		this.name = name;
		this.email = email;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
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
