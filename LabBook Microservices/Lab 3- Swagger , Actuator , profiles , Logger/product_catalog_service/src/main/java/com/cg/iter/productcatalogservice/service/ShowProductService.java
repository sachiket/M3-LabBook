package com.cg.iter.productcatalogservice.service;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productcatalogservice.entity.Product;
import com.cg.iter.productcatalogservice.entity.Products;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ShowProductService {

	@Autowired
	RestTemplate restTemplate;
	
	private String productMsURL = "http://product-service/product";
	
	@HystrixCommand(fallbackMethod = "getFallbackProducts",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			})
	public Products ShowProducts() {
		return restTemplate.getForObject(productMsURL+"/getall", Products.class);
	}
	
	Products getFallbackProducts() {
		return new Products(Arrays.asList(
				new Product(9999, "FallBack Product", "FallBack")
				));
	}
	
}
