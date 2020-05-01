package com.cg.iter.productMS.entity;

public class ProductStock {

	private int productId;
	private int quantity;
	public ProductStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductStock(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
