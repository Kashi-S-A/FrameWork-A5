package com.ty.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee employee = em.find(Employee.class, 102);
		

		if (employee != null) {
			et.begin();
			em.remove(employee);
			et.commit();
			System.out.println("Deleted");
		} else {
			System.out.println("Employee not found");
		}
	}
}
