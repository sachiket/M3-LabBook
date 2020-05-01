package com.cg.iter.productstock.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.productstock.entity.ProductStock;


public interface StockRepository extends CrudRepository<ProductStock, Integer>{


}
