package com.ty.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.entity.Account;
import com.ty.entity.Bank;

public class FetchByBank {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Bank bank = em.find(Bank.class, 2);

		if (bank != null) {
			System.out.println("----------Bank Details-----------");
			System.out.println("Bank ID: " + bank.getBid());
			System.out.println("Bank Name: " + bank.getName());
			
			List<Account> accounts = bank.getAccounts();
			
			System.out.println("=========Accounts=========");
			
			for (Account account : accounts) {
				System.out.println("Account Number: " + account.getAccno());
				System.out.println("Account Holder Name: " + account.getName());
				System.out.println("Account Balance: " + account.getBalance());
				System.out.println("---------------------------");
			}
		} else {
			System.out.println("Bank not found");
		}
	}
}
