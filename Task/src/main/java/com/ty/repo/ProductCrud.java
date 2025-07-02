package com.ty.repo;

import com.ty.entity.Product;

/**
 * ProductCrud class is responsible for performing CRUD operations on Product
 * entities. It interacts with the database to save, retrieve, update, and
 * delete products.
 */
public class ProductCrud {

	/**
	 * Saves a product to the database. Existing category should be added to the
	 * product before saving.
	 * 
	 * @param product The product to be saved(Parameter as product object).
	 * @return A message indicating the result of the save operation , return
	 *         successful message with Product id {@code Id},else return Already
	 *         exists message.
	 */

	public String saveProduct(Product product) {
		// TODO: Implement the logic to save the product to the database
	}

	/**
	 * Retrieves a product by its ID.
	 * 
	 * @param pid The ID of the product to be retrieved.
	 * @return The product with the specified ID, or null if not found.
	 */
	public Product getProductById(Integer pid) {
		// TODO: Implement the logic to retrieve the product by ID from the database
	}

	/**
	 * Deletes a product by its ID. If the product is found, it will be removed,
	 * respective category should not be deleted.
	 * 
	 * @param pid The ID of the product to be deleted.
	 * @return A message indicating the result of the delete operation,return
	 *         'Delete Successfully message' if deleted else throw
	 *         {@code ProductNotFoundException}.
	 */

	public String deleteProductById(Integer pid) {
		// TODO: Implement the logic to delete the product by ID from the database
	}

	/**
	 * Updates a product's details.
	 * 
	 * @param pid     The ID of the product to be updated.
	 * @param newName The new name for the product.
	 * @return A message indicating the result of the update operation, return
	 *         successful message with Product id {@code Id},else throw
	 *         {@code ProductNotFoundException}..
	 */
	public String updateProduct(Integer pid, String newName) {
		// TODO: Implement the logic to update the product's name in the database
	}

	/**
	 * Updates a product's details.
	 * 
	 * @param pid     The ID of the product to be updated.
	 * @param product object with new details(more than one).
	 * 
	 * @return A message indicating the result of the update operation, return
	 *         update product, else throw {@code ProductNotFoundException}.
	 */
	public String updateProduct(Integer pid, Product product) {
		// TODO: Implement the logic to update the product's details in the database
	}

	/**
	 * Retrieves all products from the database.
	 * 
	 * @return A list of all products in the database.
	 */
	public List<Product> getAllProducts() {
		// TODO: Implement the logic to retrieve all products from the database
	}

	/**
	 * Retrieves all products by category ID.
	 * 
	 * @param cid The ID of the category for which products are to be retrieved.
	 * @return A list of products belonging to the specified category.
	 */
	public List<Product> getAllProductsByCategoryId(Integer cid) {
		// TODO: Implement the logic to retrieve all products by category ID from the
		// database
	}
}
