package com.cg.iter.productMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.productMS.entity.Product;
import com.cg.iter.productMS.entity.ProductDetails;
import com.cg.iter.productMS.entity.ProductPrice;
import com.cg.iter.productMS.entity.ProductStock;
import com.cg.iter.productMS.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	private String productStockURL = "http://stock-service/stock";
	private String productPriceURL = "http://price-service/price";
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductRepository repo;
	
	@Override
	public boolean addProduct(ProductDetails productDetails) {
		restTemplate.postForObject(productStockURL+"/addNew", setProductStock(productDetails), ProductStock.class);
		restTemplate.postForObject(productPriceURL+"/add", setProductPrice(productDetails), ProductPrice.class);
		repo.save(setProduct(productDetails));
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
	
	private Product setProduct(ProductDetails productDetails) {
		Product product = new Product();
		product.setProductId(productDetails.getProductId());
		product.setProductName(productDetails.getProductName());
		product.setProductCategory(productDetails.getProductCategory());
		return product;
	}
	
	private ProductPrice setProductPrice(ProductDetails productDetails) {
		ProductPrice productPrice = new ProductPrice();
		productPrice.setProductId(productDetails.getProductId());
		productPrice.setPrice(productDetails.getPrice());
		return productPrice;
	}
	
	private ProductStock setProductStock(ProductDetails productDetails) {
		ProductStock productStock = new ProductStock();
		productStock.setProductId(productDetails.getProductId());
		productStock.setQuantity(productDetails.getQuantity());
		return productStock;
	}

}
