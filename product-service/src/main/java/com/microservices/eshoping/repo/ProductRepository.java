package com.microservices.eshoping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.eshoping.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
