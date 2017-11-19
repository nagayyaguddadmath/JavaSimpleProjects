package com.checkout.product;

public class PurchasedProduct extends Product {

	private int countOfPuchased = 0;
	
	public PurchasedProduct(Long productCode, String name, double originalPrice) {
		super(productCode, name, originalPrice);
	}

	public int getCountOfPuchased() {
		return countOfPuchased;
	}

	//parameter option has been given to increase count for bulk buy
	public void increaseCountBy(int countOfPuchased) {
		this.countOfPuchased += countOfPuchased;
	}

}
