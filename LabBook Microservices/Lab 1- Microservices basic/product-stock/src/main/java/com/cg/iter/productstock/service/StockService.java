package com.cg.iter.productstock.service;

import java.util.List;

import com.cg.iter.productstock.entity.ProductStock;

public interface StockService {

	boolean addNewStock(ProductStock productStock);
	boolean addStock(int productId, int quantity);
	boolean removeStock(int productId, int quantity);
	boolean removeAllStocks();
	ProductStock getStock(int productId );
	List<ProductStock> getall();
	
	
}
