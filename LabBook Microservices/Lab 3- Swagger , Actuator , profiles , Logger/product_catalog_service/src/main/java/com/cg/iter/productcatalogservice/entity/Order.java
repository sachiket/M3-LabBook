package com.cg.iter.productcatalogservice.entity;





public class Order {


	private int productId;
	private int quantity;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int productId) {
		super();
		this.productId = productId;
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

	public Order(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	
	
	
}
