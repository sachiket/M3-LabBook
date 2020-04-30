package com.cg.iter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.entities.Product;
import com.cg.iter.services.ProductService;

@RestController
public class Controller {
    
    @Autowired private ProductService service;
    
    @GetMapping("/")
    public String createSample() {
        return "Welcome ITER";
    }
    
    @GetMapping("/rest/products")
    public List<Product> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/rest/product/{id}")
    public Product findProductById(@PathVariable("id") int id){
        return service.find(id);
    }
    
    @GetMapping("/post")
	public String showForm(Model model) {
		Product p = new Product();
		p.setPrice(100D);
		model.addAttribute("product",p);
		return "form";
	}
	
	@PostMapping
	public String submit(Model model,
				@ModelAttribute("product") Product product,
				BindingResult results) {
		model.addAttribute("msg","product added");
		service.create(product);
		return "success";
	}
}