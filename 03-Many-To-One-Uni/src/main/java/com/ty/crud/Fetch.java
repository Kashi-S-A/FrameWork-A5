package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Product;
import com.ty.entity.Review;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Review review = em.find(Review.class, 103);

		if (review != null) {
			System.out.println("===========Review found:============");
			System.out.println("Review ID: " + review.getId());
			System.out.println("Review Message: " + review.getMsg());

			System.out.println("===========Product Details:============");

			Product product = review.getProduct();

			System.out.println("Product ID: " + product.getId());
			System.out.println("Product Name: " + product.getName());
			System.out.println("Product Price: " + product.getPrice());

		} else {
			System.out.println("Review not found");
		}
	}
}
