package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();

		Student s = new Student(104, "Mangi", "mangi@gmail.com");
		
		et.begin();
		em.persist(s);
		et.commit();
		
		System.out.println("student saved");

	}
}