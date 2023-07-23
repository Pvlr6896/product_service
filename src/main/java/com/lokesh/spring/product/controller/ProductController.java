package com.lokesh.spring.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lokesh.spring.product.couponservice.dto.Coupon;
import com.lokesh.spring.product.model.Product;
import com.lokesh.spring.product.repository.ProductRepository;

@RestController
@RequestMapping("/product/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${coupon.service.url}")
	private String couponServiceUrl;

	@PostMapping("/createproduct")
	public Product createProduct(@RequestBody Product product) throws Exception {
		try {
			Coupon coupon = restTemplate.getForObject(couponServiceUrl+product.getCouponCode(), Coupon.class);
			product.setPrice(product.getPrice()-coupon.getDiscount());
			return productRepository.save(product);
		}
		catch(Exception e) {
			throw new Exception(e.toString());
		}
	}

	@GetMapping("/getproduct/{name}")
	public Optional<Product> getProduct(@PathVariable String name) {
		return productRepository.findByName(name);
	}
}
