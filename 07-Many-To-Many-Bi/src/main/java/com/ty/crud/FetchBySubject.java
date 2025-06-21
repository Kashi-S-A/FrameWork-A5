package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Student;
import com.ty.entity.Subject;

public class FetchBySubject {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Subject subject = em.find(Subject.class, 1);

		if (subject != null) {
			System.out.println("===========Subject found:============");
			System.out.println("ID: " + subject.getId());
			System.out.println("Name: " + subject.getName());
			System.out.println("Days: " + subject.getDays());

			System.out.println("=============Students:============ ");
			List<Student> students = subject.getStudents();

			for (Student student : students) {
				System.out.println("Student ID: " + student.getId());
				System.out.println("Student Name: " + student.getName());
				System.out.println("Standard: " + student.getStd());
				System.out.println("-------------------------------");
			}

		} else {
			System.out.println("Subject not found");
		}
	}
}
