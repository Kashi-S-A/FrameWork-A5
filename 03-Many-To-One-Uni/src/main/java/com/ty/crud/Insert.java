package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Review;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product product = new Product(2, "Mobile", 40000);

		Review review1 = new Review(103, "Bad");

		review1.setProduct(product);

		et.begin();
		em.persist(product);
		em.persist(review1);
		et.commit();

		System.out.println("Data inserted successfully");
	}
}
