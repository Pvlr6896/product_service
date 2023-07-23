package com.lokesh.spring.product.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lokesh.spring.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	Optional<Product> findByName(String name);

}
