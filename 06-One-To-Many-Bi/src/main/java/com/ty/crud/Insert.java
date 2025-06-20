package com.ty.crud;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank bank = new Bank();
		bank.setBid(2);
		bank.setName("HDFC Bank");

		Account account1 = new Account();
		account1.setAccno(103);
		account1.setName("Charlie");
		account1.setBalance(7000.0);
		account1.setBank(bank);

		Account account2 = new Account();
		account2.setAccno(104);
		account2.setName("David");
		account2.setBalance(1000.0);
		account2.setBank(bank);
		
		et.begin();
		em.persist(account1);
		em.persist(account2);
		em.persist(bank);
		et.commit();

		System.out.println("Data inserted successfully");
	}
}
