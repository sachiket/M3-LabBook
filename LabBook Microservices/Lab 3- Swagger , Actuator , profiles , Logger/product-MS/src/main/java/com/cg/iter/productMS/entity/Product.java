package com.cg.iter.productMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Table")
public class Product {

	@Id
	private int productId;
	@Column(name = "Name")
	private String productName;
	@Column(name = "Category")
	private String productCategory;
	public Product() {}

	public Product(String productName, String productCategory) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
	
	}
	public Product(int productId, String productName, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
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

}
