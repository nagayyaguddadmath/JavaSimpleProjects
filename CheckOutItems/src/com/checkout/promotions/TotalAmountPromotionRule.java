package com.checkout.promotions;

import java.util.Set;

import com.checkout.product.Product;

public class TotalAmountPromotionRule extends PromotionRule {

	private double minAmountNeeded; 
	private double discountToBeInPerc = 0.0d;

	public TotalAmountPromotionRule(double minAmountNeeded, double discountToBeInPerc, int applyOrder) {
		this.minAmountNeeded = minAmountNeeded;
		this.discountToBeInPerc = discountToBeInPerc;
		this.applyOrder = applyOrder;
	}

	@Override
	public void apply(Set<Product> products) {
		Double totalBillAmount = products.stream().mapToDouble(p -> p.getOriginalPrice()).sum();
		if (totalBillAmount >= minAmountNeeded) {
			totalDiscountApplied = (totalBillAmount*discountToBeInPerc)/100;
		}
	}

}
