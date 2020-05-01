package com.cg.iter.productMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.productMS.entity.Product;
import com.cg.iter.productMS.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;
	@Override
	public boolean addProduct(Product product) {
		repo.save(product);
		return true;
	}

	@Override
	public boolean removeProduct(int productId) {
		repo.deleteById(productId);
		return true;
	}

	@Override
	public Product getProductById(int Id) {
		Optional<Product> repository =repo.findById(Id);
		if(repository.isPresent()) {
			return repository.get();
		}
		return null;
	}

	@Override
	public Product getProductByName(String productName) {
		return repo.findByproductName(productName);
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) repo.findAll();
	}

	@Override
	public boolean removeAll() {
		repo.deleteAll();
		return true;
	}

}
