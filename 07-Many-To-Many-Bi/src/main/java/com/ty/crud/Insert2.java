package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Student;
import com.ty.entity.Subject;

public class Insert2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student(2, "David", "10th");

		// Java,Python,Web

		Subject subject1 = em.find(Subject.class, 1);

		Subject subject2 = em.find(Subject.class, 2);

		Subject subject3 = new Subject(4, "Web", 30);

		student.setSubjects(Arrays.asList(subject1, subject2, subject3));

		et.begin();
		em.persist(subject3);
		em.persist(student);
		et.commit();

	}
}
