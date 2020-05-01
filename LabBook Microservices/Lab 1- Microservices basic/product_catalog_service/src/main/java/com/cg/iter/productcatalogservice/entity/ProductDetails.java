package com.cg.iter.productcatalogservice.entity;


public class ProductDetails {

	private int productId;
	private String productName;
	private String productCategory;
	private double price;
	private int quantity;
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDetails(int productId, String productName, String productCategory, double price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.quantity = quantity;
	}
	public ProductDetails(String productName, String productCategory, double price, int quantity) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
