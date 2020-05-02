package com.cg.iter.productcatalogservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productcatalogservice.entity.Order;
import com.cg.iter.productcatalogservice.entity.Product;
import com.cg.iter.productcatalogservice.entity.ProductPrice;
import com.cg.iter.productcatalogservice.entity.ProductStock;
import com.cg.iter.productcatalogservice.entity.Products;
import com.cg.iter.productcatalogservice.service.GetPriceService;
import com.cg.iter.productcatalogservice.service.ShowProductService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/catalog")
public class CatalogController {
	

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ShowProductService showProductService;
	@Autowired
	GetPriceService getPriceService;
	
	private String productStockURL = "http://stock-service/stock";
	private String productCartURL = "http://cart-service/cart";
	
	
	@ApiOperation(
			value = "Show all products",
			notes = "Can select a product from it with product id.",
			response = List.class
			)
	@GetMapping("/products")
	List<Product> ShowProducts() {
		Products products = showProductService.ShowProducts();
		return products.getProducts();
	}
	
	@GetMapping("/getprice")
	ProductPrice checkPrice(@RequestParam int productId) {
		return getPriceService.checkPrice(productId);
	}
	
	@PostMapping("/addtocart")
	boolean addToCart(@RequestParam int productId, @RequestParam int quantity) {
		//getting the product stock from product service
		ProductStock productStock = restTemplate.getForObject(productStockURL+"/get?productId="+productId, ProductStock.class);
		//checking for available quantity in stock
		if(productStock.getQuantity()<quantity) {
			return false;
		}
		//stock update
//		restTemplate.postForObject(productStockURL+"/remove?productId="+productId+"&quantity="+quantity, true,Boolean.class);
		Order order = new Order(productId, quantity);
		//add to cart
		restTemplate.postForObject(productCartURL+"/add", order,Order.class);
		return true;
	}
	

	
	
	
	
	
	
	

}
