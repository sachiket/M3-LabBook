package com.cg.iter.productstock.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class ProductStock {

	@Id
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
