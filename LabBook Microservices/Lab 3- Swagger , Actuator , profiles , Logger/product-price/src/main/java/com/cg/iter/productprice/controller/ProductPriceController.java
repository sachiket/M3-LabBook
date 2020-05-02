package com.cg.iter.productprice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.productprice.entity.ProductPrice;
import com.cg.iter.productprice.service.ProductPriceService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

@RestController
@RequestMapping("/price")
public class ProductPriceController {

	private static final Logger logger = LoggerFactory.getLogger(ProductPriceController.class);
	
	@Autowired
	ProductPriceService productPriceService;
	//requesting mapping , get mapping , post mapping
	
	//for add we need productid and price
	//reuest object
	@PostMapping("/add")
	ResponseEntity<String> addNewProductPrice(@RequestBody ProductPrice productPrice) {
		productPriceService.addNewProductPrice(productPrice);
		logger.warn("A new product price in been added!!"+productPrice.toString());
	
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	//localhost:8087/price/remove?productId=1234
	@PostMapping("/remove")
	String removeProductPrice(@RequestParam int productId) {
		productPriceService.removeProductPrice(productId);
		return "product removed";
	}
	
	//localhost:8087/price/get?productId=1234
	//is this case 1234 is request params
	@GetMapping("/get")
	ProductPrice findProductPriceById(@RequestParam int productId) {
		ProductPrice price =productPriceService.getProductPrice(productId);
		if(price==null) {
			logger.error("Product not found!");
			return null;
		}
		return price;
	}
	
	@GetMapping("/getall")
	List<ProductPrice> getall(){
		return productPriceService.getall();
	}
	
	@GetMapping("/removeall")
	boolean removeAll() {
		return productPriceService.removeAll();
	}
	
	
}
