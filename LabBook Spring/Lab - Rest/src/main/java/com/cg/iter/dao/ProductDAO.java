package com.cg.iter.dao;

import java.util.List;

import com.cg.iter.entities.Product;

public interface ProductDAO {
	
	    public void save(Product p);
	    public Product findById(Integer productId);
	    public List<Product> findAll();

}
