package com.cg.iter.productcatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productcatalogservice.entity.ProductPrice;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class GetPriceService {

	@Autowired
	RestTemplate restTemplate;
	private String productPriceURL = "http://price-service/price";
	
	@HystrixCommand(fallbackMethod = "getFallbackPrice",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			})
	public ProductPrice checkPrice(@RequestParam int productId) {
		return restTemplate.getForObject(productPriceURL+"/get?productId="+productId, ProductPrice.class);
	}
	
	ProductPrice getFallbackPrice(@RequestParam int productId) {
		return new ProductPrice(9999,0);
	}
}
