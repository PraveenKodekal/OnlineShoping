package com.microservices.eshoping.service;

import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.microservices.eshoping.dto.ProductRequest;
import com.microservices.eshoping.dto.ProductResponse;
import com.microservices.eshoping.model.Product;
import com.microservices.eshoping.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepo;
	
	private final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	
	
	public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepo.save(product);
        logger.info("Product "+product.getPid()+" Added to the list");
    }




	public List<ProductResponse> allProducts() {
		// TODO Auto-generated method stub
		 List<Product>products = productRepo.findAll();
		 //convert product into ProductResponse
		 return products.stream().map(this :: mapToProduct).toList();
		 
	}
	
	private ProductResponse mapToProduct(Product product) {
		return ProductResponse.builder()
				.pid(product.getPid())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

}
