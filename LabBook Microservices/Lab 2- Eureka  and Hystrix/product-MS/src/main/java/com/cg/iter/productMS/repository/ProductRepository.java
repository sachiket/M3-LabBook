package com.cg.iter.productMS.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.productMS.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	Product findByproductName(String productName);

}
