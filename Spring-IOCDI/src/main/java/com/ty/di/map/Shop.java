package com.ty.di.map;

import java.util.Map;

public class Shop {

	private String shopName;
	private String shopOwner;

	private Map<String, Double> products;

	public void displayShopInfo() {
		System.out.println("Shop Name: " + shopName);
		System.out.println("Shop Owner: " + shopOwner);
		System.out.println("==============Products:================");
		for (Map.Entry<String, Double> entry : products.entrySet()) {
			System.out.println("Product: " + entry.getKey() + ", Price: " + entry.getValue());
		}
	}

	public void setProducts(Map<String, Double> products) {
		this.products = products;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}
}
