package com.cg.iter.productcartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.productcartservice.entity.Order;
import com.cg.iter.productcartservice.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public boolean addToCart(Order order) {
		cartRepository.save(order);
		return true;
	}

	@Override
	public boolean removeItemFromCart(int productId) {
		cartRepository.deleteById(productId);
		return true;
	}

	@Override
	public boolean removeAll() {
		cartRepository.deleteAll();
		return true;
	}

	@Override
	public List<Order> getAll() {
		
		return (List<Order>) cartRepository.findAll();
	}


}
