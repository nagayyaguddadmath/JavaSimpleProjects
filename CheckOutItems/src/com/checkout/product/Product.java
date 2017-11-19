package com.checkout.product;

public class Product {
	private Long productCode;
	private String name;
	private double originalPrice;
	
	public Product(Long productCode, String name, double originalPrice) {
		this.productCode = productCode;
		this.name = name;
		this.originalPrice = originalPrice;
	}
	
	
	public Long getProductCode() {
		return productCode;
	}
	
	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	


}
