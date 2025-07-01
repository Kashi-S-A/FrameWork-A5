package com.ty.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.entity.Category;

public class CategoryCrud {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private static final EntityManager em = emf.createEntityManager();
	private static final EntityTransaction et = em.getTransaction();

	public String saveCategory(Category category) {
		if (category != null) {
			try {
				et.begin();
				Category savedCat = em.merge(category);
				et.commit();
				System.out.println("--------------------");
				return "category saved with id: " + savedCat.getCid();

			} catch (Exception e) {
				e.printStackTrace();
				return "already exists";
			}
		} else {
			return "Category cannot be null";
		}

	}

	public Category getCategoryById(Integer cid) {
		return em.find(Category.class, cid);
	}

	public String deleteCategoryById(Integer cid) {

		Category category = em.find(Category.class, cid);
		if (category != null) {
			try {
				et.begin();
				em.remove(category);
				et.commit();
				return "Category deleted successfully";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error deleting category";
			}
		} else {
			return "Category not found";
		}
	}

	public String updateCategory(Integer cid, String newName) {

		Category category = em.find(Category.class, cid);
		if (category != null) {
			try {
				et.begin();
				category.setName(newName);
				em.merge(category);
				et.commit();
				return "Category updated successfully";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Category not found";
	}

	/**
	 * get all categories from database.
	 * 
	 * @return A list of all categories in the database.
	 */
	public List<Category> getAllCategories() {
		// TODO: Implement the logic to retrieve all categories from the database
	}

}
