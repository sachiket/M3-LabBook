package com.cg.iter.productstock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.productstock.entity.ProductStock;
import com.cg.iter.productstock.repository.StockRepository;
@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stock;
	@Override
	public boolean addNewStock(ProductStock productStock) {
		stock.save(productStock);
		return true;
	}

	@Override
	public boolean addStock(int productId, int quantity) {
		Optional<ProductStock> findStock = stock.findById(productId);
		ProductStock productStock = null;
		if(findStock.isPresent()) {
			productStock = findStock.get();
			productStock.setQuantity(productStock.getQuantity()+quantity);
			stock.save(productStock);
		}
		return true;
	}

	@Override
	public boolean removeStock(int productId, int quantity) {
		Optional<ProductStock> findStock = stock.findById(productId);
		ProductStock productStock = null;
		if(findStock.isPresent()) {
			productStock = findStock.get();
			
			if(productStock.getQuantity()<quantity)return false;
			
			productStock.setQuantity(productStock.getQuantity()-quantity);
			stock.save(productStock);
		}
		return true;
	}

	@Override
	public boolean removeAllStocks() {
		stock.deleteAll();
		return true;
	}

	@Override
	public ProductStock getStock(int productId) {
		Optional<ProductStock> findStock = stock.findById(productId);
		if(findStock.isPresent()) {
			return findStock.get();
		}
		return null;
	}

	@Override
	public List<ProductStock> getall() {
	
		return (List<ProductStock>) stock.findAll();
	}
	

}
