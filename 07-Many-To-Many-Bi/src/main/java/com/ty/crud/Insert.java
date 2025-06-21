package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Student;
import com.ty.entity.Subject;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Subject subject1 = new Subject(1, "Java", 30);

		Subject subject2 = new Subject(2, "Python", 40);

		Subject subject3 = new Subject(3, "C++", 20);

		Student student1 = new Student(1, "Alice", "10th");

		student1.setSubjects(Arrays.asList(subject1, subject2, subject3));

		et.begin();
		em.persist(subject1);
		em.persist(subject2);
		em.persist(subject3);
		em.persist(student1);
		et.commit();

		System.out.println("Data inserted successfully");
	}
}
