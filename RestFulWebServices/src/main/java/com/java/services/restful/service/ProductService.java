package com.java.services.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.services.restful.entity.Product;
import com.java.services.restful.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prodRepo;

	public Product saveProduct(Product prod) {
		return prodRepo.save(prod);

	}
	
	public List<Product> saveProducts(List<Product> productList) {
		return prodRepo.saveAll(productList);
	}
	
	public List<Product> getProducts() {
		return prodRepo.findAll();
	}
	
	public Product getProductById(int id) {
		return prodRepo.findById(id).orElse(null);
	}
	
	public List<Product> getProductByName(String name) {
		return prodRepo.findByName(name);
	}
	
	public void deleteProductById(int id) {
		 prodRepo.deleteById(id);
	}
	
	public Product updateProductById(Product prod) {
		Product existingProduct = prodRepo.findById(prod.getId()).orElse(null);
		existingProduct.setName(prod.getName());
		existingProduct.setPrice(prod.getPrice());
		existingProduct.setQuantity(prod.getQuantity());
		return prodRepo.save(existingProduct);
	}

}
