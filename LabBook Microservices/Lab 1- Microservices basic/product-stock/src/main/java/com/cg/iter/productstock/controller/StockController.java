package com.cg.iter.productstock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productstock.entity.ProductStock;
import com.cg.iter.productstock.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	StockService stockService;
	@Autowired
	RestTemplate restTempplate;
	
	@PostMapping("/addNew")
	ResponseEntity<String> addNewStock(@RequestBody ProductStock productStock) {
		stockService.addNewStock(productStock);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	@PostMapping("/add")
	String addStock(@RequestParam int productId, @RequestParam int quantity) {
		stockService.addStock(productId, quantity);
		return "product updated";
	}
	
	@PostMapping("/remove")
	String removeStock(@RequestParam int productId, @RequestParam int quantity) {
		stockService.removeStock(productId, quantity);
		return "product updated";
	}
	@GetMapping("/get")
	ProductStock getStock(@RequestParam int productId) {
		return stockService.getStock(productId);
	}
	@GetMapping("/removeall")
	boolean removeAll() {
		stockService.removeAllStocks();
		return true;
	}
	
	@GetMapping("/getall")
	List<ProductStock> getAll(){
		return stockService.getall();
	}
	
}
