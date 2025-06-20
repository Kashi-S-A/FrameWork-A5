package com.ty.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class FetchByAccount {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Account account = em.find(Account.class, 103l);

		if (account != null) {
			System.out.println("----------account Details-----------");
			System.out.println("accountNo : " + account.getAccno());
			System.out.println(" Name: " + account.getName());
			System.out.println(" Balance: " + account.getBalance());
			Bank bank = account.getBank();

			System.out.println("=============Bank Details:===========");
			System.out.println("Bank ID: " + bank.getBid());
			System.out.println("Bank Name: " + bank.getName());

		} else {
			System.out.println("Bank not found");
		}
	}
}
