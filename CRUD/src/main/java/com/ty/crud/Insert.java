package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Employee;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();

		Employee employee = new Employee(102, "Dingi", "dingi@gmail.com", "6543234567");

		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(employee);
		
		et.commit();
		
		System.out.println("Inserted");
	}
}
