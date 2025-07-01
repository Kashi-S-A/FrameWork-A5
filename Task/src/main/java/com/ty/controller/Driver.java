package com.ty.controller;

import java.util.Scanner;

import com.ty.entity.Category;
import com.ty.repo.CategoryCrud;

public class Driver {
	public static void main(String[] args) {

		System.out.println("Welcome to the Category and Product Management System");

		CategoryCrud categoryCrud = new CategoryCrud();
		while (true) {
			System.out.println("enter 1 to save category");
			System.out.println("enter 2 to fetch category by id");
			System.out.println("enter 3 to fetch all categories");
			System.out.println("enter 4 to update category");
			System.out.println("enter 5 to delete category by id");
			System.out.println("enter 6 to exit");

			Scanner scanner = new Scanner(System.in);

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("======================================");
				Category category = new Category();
				System.out.println("enter name of the category");
				String name = scanner.next();
				category.setName(name);
				String result = categoryCrud.saveCategory(category);
				System.out.println(result);
				System.out.println("======================================");
			}
				break;
			case 2: {
				System.out.println("======================================");
				System.out.println("enter category Id to fetch");
				int cid = scanner.nextInt();
				Category category = categoryCrud.getCategoryById(cid);
				if (category != null) {
					System.out.println("Category ID: " + category.getCid());
					System.out.println("Category Name: " + category.getName());
				} else {
					System.out.println("Category not found");
				}
				System.out.println("=======================================");
			}
				break;
			case 5: {

				System.out.println("======================================");
				System.out.println("enter category Id to delete");
				int cid = scanner.nextInt();
				String result = categoryCrud.deleteCategoryById(cid);
				System.out.println(result);
				System.out.println("======================================");
			}
				break;
			case 6: {
				System.out.println("Exiting the application. Goodbye!");
				return;
			}
			default: {
				System.out.println("Invalid choice, please try again.");
			}
				break;
			}
		}

	}
}
