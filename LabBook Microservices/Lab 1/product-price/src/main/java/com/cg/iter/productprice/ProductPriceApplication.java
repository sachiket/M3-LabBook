package com.cg.iter.productprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceApplication.class, args);
	}

}
//controller -> services - > repository (to perform all crud operation)
//service -> controller ->any Rest call