package com.java.services.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.services.restful.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);

}
