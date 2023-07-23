package com.lokesh.spring.product.model;

import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	private String name;
	private String description;
	private Double price;
	@Transient
	private String couponCode;

	public Product(String name, String description, Double price,String couponCode) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.couponCode=couponCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
}
