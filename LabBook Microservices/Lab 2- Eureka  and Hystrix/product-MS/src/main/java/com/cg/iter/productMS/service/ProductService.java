package com.cg.iter.productMS.service;

import java.util.List;

import com.cg.iter.productMS.entity.Product;
import com.cg.iter.productMS.entity.ProductDetails;

public interface ProductService {

	boolean addProduct(ProductDetails productDetails);
	boolean removeProduct(int productId);
	Product getProductById(int Id);
	Product getProductByName(String productName);
	List<Product> getAllProducts();
	boolean removeAll();
}
