package com.ty.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Employee employee = em.find(Employee.class, 105);

		if (employee != null) {
			System.out.println("ID: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Phone: " + employee.getPhone());
		} else {
			System.out.println("Employee not found");
		}
	}
}
