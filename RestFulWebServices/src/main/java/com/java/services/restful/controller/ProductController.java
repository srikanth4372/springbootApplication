package com.java.services.restful.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.services.restful.entity.Product;
import com.java.services.restful.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService prodService; 
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product prod) {
		return prodService.saveProduct(prod);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> prodList){
		return prodService.saveProducts(prodList);
	}
	
	@GetMapping("/Product")
	public List<Product> getProducts() {
		return prodService.getProducts();
	}
	
	@GetMapping("/Product/{id}")
	public Product getProductById(@PathVariable int id ) {
		return prodService.getProductById(id);
	}
	
	@GetMapping("/ProductByName/{name}")
	public List<Product> getProductByName(@PathVariable String name ) {
		return prodService.getProductByName(name);
	}
	
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product prod) {
		return prodService.updateProductById(prod);
	}
	
	@DeleteMapping("/Product/{id}")
	public void deleteProduct(@PathVariable int id) {
		prodService.deleteProductById(id); 
	}
}
