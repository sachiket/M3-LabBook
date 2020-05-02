package com.cg.iter.productcatalogservice.entity;

import java.util.List;

public class Products {

	private List<Product> products;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Products(List<Product> products) {
		super();
		this.products = products;
	}
}
