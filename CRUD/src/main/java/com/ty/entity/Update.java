package com.ty.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee employee = em.find(Employee.class, 104);

		if (employee != null) {
			et.begin();
			employee.setName("Pengi");
			employee.setEmail("pengi@gmail.com");

			em.merge(employee);
			et.commit();
			System.out.println("Updated");
		} else {
			System.out.println("Employee not found");
		}
	}
}
