package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository productRepo;
	
	@PostMapping(value ="/product", consumes = "application/json")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productRepo.save(product);
		return new ResponseEntity<String>("Product saved", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/products", produces = "application/json" )
	public ResponseEntity<List<Product>> getproducts() {
		List<Product> products = productRepo.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}
