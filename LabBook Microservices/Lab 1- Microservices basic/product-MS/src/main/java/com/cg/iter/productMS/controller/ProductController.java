package com.cg.iter.productMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productMS.entity.Product;
import com.cg.iter.productMS.entity.ProductDetails;
import com.cg.iter.productMS.entity.ProductPrice;
import com.cg.iter.productMS.entity.ProductStock;
import com.cg.iter.productMS.entity.Products;
import com.cg.iter.productMS.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private String productStockURL = "http://stock-service/stock";
	private String productPriceURL = "http://price-service/price";
	
	@Autowired
	private ProductService productService;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	String addProduct(@RequestBody ProductDetails productDetails) {

		restTemplate.postForObject(productStockURL+"/addNew", setProductStock(productDetails), ProductStock.class);
		restTemplate.postForObject(productPriceURL+"/add", setProductPrice(productDetails), ProductPrice.class);
		productService.addProduct(setProduct(productDetails));
		return "product added";
	}
	
	@GetMapping("/get/byid")
	Product getProductById(int productId) {
		return productService.getProductById(productId);
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
	
	private Product setProduct(ProductDetails productDetails) {
		Product product = new Product();
		product.setProductId(productDetails.getProductId());
		product.setProductName(productDetails.getProductName());
		product.setProductCategory(productDetails.getProductCategory());
		return product;
	}
	
	private ProductPrice setProductPrice(ProductDetails productDetails) {
		ProductPrice productPrice = new ProductPrice();
		productPrice.setProductId(productDetails.getProductId());
		productPrice.setPrice(productDetails.getPrice());
		return productPrice;
	}
	
	private ProductStock setProductStock(ProductDetails productDetails) {
		ProductStock productStock = new ProductStock();
		productStock.setProductId(productDetails.getProductId());
		productStock.setQuantity(productDetails.getQuantity());
		return productStock;
	}
	
	
}
