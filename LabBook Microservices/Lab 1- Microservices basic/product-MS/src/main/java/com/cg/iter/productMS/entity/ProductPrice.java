package com.cg.iter.productMS.entity;

import javax.persistence.Id;

public class ProductPrice {
	private int productId;
	private double price;
	public ProductPrice() {
		super();
	}
	public ProductPrice(int productId, double price) {
		super();
		this.productId = productId;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
