package com.cg.iter.productcartservice.service;

import java.util.List;

import com.cg.iter.productcartservice.entity.Order;

public interface CartService {

	boolean addToCart(Order order);
	boolean removeItemFromCart(int productId);
	boolean removeAll();
	List<Order> getAll();
}
