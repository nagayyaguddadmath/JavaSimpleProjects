package com.src.checkout.product;

public class PurchasedProduct extends Product {

	private int countOfPuchased = 0;
	
	public PurchasedProduct(String productCode, String name, double originalPrice) {
		super(productCode, name, originalPrice);
	}

	public PurchasedProduct(Product product) {
		super(product.getProductCode(), product.getName(), product.getOriginalPrice());
	}

	public int getCountOfPuchased() {
		return countOfPuchased;
	}

	//parameter option has been given to increase count for bulk buy
	public void increaseCountBy(int countOfPuchased) {
		this.countOfPuchased += countOfPuchased;
	}

}
