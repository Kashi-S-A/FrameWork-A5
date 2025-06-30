package com.ty.di.list;

import java.util.List;

public class Student {

	private String studentName;
	private int studentId;
	private List<String> subjects;

	public Student(String studentName, int studentId, List<String> subjects) {
		this.studentName = studentName;
		this.studentId = studentId;
		this.subjects = subjects;
	}

	public void displayStudentInfo() {
		System.out.println("Student Name: " + studentName);
		System.out.println("Student ID: " + studentId);
		System.out.println("Subjects: " + subjects);
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

}
