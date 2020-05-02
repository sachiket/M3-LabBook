package com.cg.iter.productMS.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.productMS.entity.Product;
import com.cg.iter.productMS.entity.ProductDetails;
import com.cg.iter.productMS.entity.Products;
import com.cg.iter.productMS.service.ProductService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

	
	@PostMapping("/add")
	String addProduct(@RequestBody ProductDetails productDetails) {
		productService.addProduct(productDetails);
		return "product added";
	}
	
	@GetMapping("/get/byid")
	Product getProductById(int productId) {
		
		Product product = productService.getProductById(productId);
		if(product==null) {
			logger.error("No product found with this product ID!");
		}
		return product;
	}
	
	@GetMapping("/get/byname")
	Product getProductByName(String productName) {
		return productService.getProductByName(productName);
	}

	@GetMapping("getall")
	Products getall(){
		Products products = new Products();
		products.setProducts(productService.getAllProducts());
		return products;
	}
	
	@GetMapping("removeall")
	boolean removeAll() {
		return productService.removeAll();
	}
	
	
}
