package com.cg.iter.productcartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productcartservice.entity.Order;
import com.cg.iter.productcartservice.service.CartService;

@Controller
@RequestMapping("/cart")
public class cartController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CartService cartService;
	
	@PostMapping("/add")
	boolean addToCart(@RequestBody Order order) {
		cartService.addToCart(order);
		return true;
	}
	
	@PostMapping("/remove")
	boolean removeFromCart(@RequestParam int productId) {
		cartService.removeItemFromCart(productId);
		return true;
	}
	
	@GetMapping("/removeall")
	boolean removeAll() {
		cartService.removeAll();
		return true;
	}
	
	@GetMapping("/getall")
	List<Order> getAll() {
		return cartService.getAll();	
	}
	
}
