package com.cg.iter.productprice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.productprice.entity.ProductPrice;
import com.cg.iter.productprice.repository.PriceRepository;

@Service
public class ProductPriceServiceImpl implements ProductPriceService{

	@Autowired
	PriceRepository repo;
	
	@Override
	public boolean addNewProductPrice(ProductPrice productPrice) {
		repo.save(productPrice);
		return true;
	}

	@Override
	public boolean updateProductPrice(int productId, double price) {
		//optional is a data type in java.util methods 
		//some of the useful methods are .isPresent() .get()
		Optional<ProductPrice> findProduct = repo.findById(productId);
		//optional has differnt 
		ProductPrice productPrice = null;
		if(findProduct.isPresent()) {
			productPrice = findProduct.get();
			productPrice.setPrice(price);
			repo.save(productPrice);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeProductPrice(int productId) {
		repo.deleteById(productId);
		return true;
	}

	@Override
	public ProductPrice getProductPrice(int productId) {
		Optional<ProductPrice> findProduct = repo.findById(productId);
		if(findProduct.isPresent()) {
			return findProduct.get();
		}
		return null;
	}

	@Override
	public boolean removeAll() {
		repo.deleteAll();
		return true;
	}

	@Override
	public List<ProductPrice> getall() {
		return (List<ProductPrice>) repo.findAll();
		
	}

}
