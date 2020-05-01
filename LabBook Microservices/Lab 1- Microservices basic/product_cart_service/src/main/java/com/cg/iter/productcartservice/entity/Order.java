package com.cg.iter.productcartservice.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_tbl")
public class Order {

	@Id
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
