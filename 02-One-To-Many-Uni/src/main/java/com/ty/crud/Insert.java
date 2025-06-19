package com.ty.crud;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		System.out.println("created");
	}
}
