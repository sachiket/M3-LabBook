package com.cg.iter.productprice.service;

import java.util.List;

import com.cg.iter.productprice.entity.ProductPrice;
//service interface
//2nd step
public interface ProductPriceService {

	boolean addNewProductPrice(ProductPrice productPrice);
	boolean updateProductPrice(int productId, double price);
	boolean removeProductPrice(int productId);
	ProductPrice getProductPrice(int productId);
	boolean removeAll();
	List<ProductPrice> getall();
	
}
