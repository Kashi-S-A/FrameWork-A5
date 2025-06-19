package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = em.find(Student.class, 101);

		if (student == null) {
			System.out.println("Not found");
		} else {
			et.begin();
			em.remove(student);
			et.commit();
			System.out.println("Deleted");
		}
	}
}
