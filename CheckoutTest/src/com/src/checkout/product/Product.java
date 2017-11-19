package com.src.checkout.product;

public class Product {
	private String productCode;
	private String name;
	private double originalPrice;
	
	public Product(String productCode, String name, double originalPrice) {
		this.productCode = productCode;
		this.name = name;
		this.originalPrice = originalPrice;
	}
	
	
	public String getProductCode() {
		return productCode;
	}
	
	public String getName() {
		return name;
	}
	
	public double getOriginalPrice() {
		return originalPrice;
	}


}
