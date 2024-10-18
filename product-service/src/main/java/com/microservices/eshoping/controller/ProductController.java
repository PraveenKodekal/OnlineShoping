package com.microservices.eshoping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.eshoping.dto.ProductRequest;
import com.microservices.eshoping.dto.ProductResponse;
import com.microservices.eshoping.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor

public class ProductController {
	private final ProductService productService;
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/addproduct")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createsProduct(@RequestBody ProductRequest product) {
		productService.createProduct(product);
	}

	@GetMapping("/allproducts")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		logger.info("All Products List ");
		return productService.allProducts();

	}
}
