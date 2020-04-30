package com.cg.iter.services;

import java.util.List;

import com.cg.iter.entities.Product;

public interface ProductService {

	Product find(int productId);
    List<Product> getAll();
    void create(Product p);
}
