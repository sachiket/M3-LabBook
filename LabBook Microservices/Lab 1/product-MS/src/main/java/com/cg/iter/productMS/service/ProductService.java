package com.cg.iter.productMS.service;

import java.util.List;

import com.cg.iter.productMS.entity.Product;

public interface ProductService {

	boolean addProduct(Product product);
	boolean removeProduct(int productId);
	Product getProductById(int Id);
	Product getProductByName(String productName);
	List<Product> getAllProducts();
	boolean removeAll();
}
