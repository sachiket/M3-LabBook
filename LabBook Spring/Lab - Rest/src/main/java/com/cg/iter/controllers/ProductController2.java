package com.cg.iter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.iter.entities.Product;
import com.cg.iter.services.ProductService;

@Controller
@RequestMapping("/post")
public class ProductController2 {

	@Autowired private ProductService service;
	@GetMapping
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