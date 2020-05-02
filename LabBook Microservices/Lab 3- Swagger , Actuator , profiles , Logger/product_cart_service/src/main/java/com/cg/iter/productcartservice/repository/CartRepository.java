package com.cg.iter.productcartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.iter.productcartservice.entity.Order;

public interface CartRepository extends CrudRepository<Order, Integer>{

}
