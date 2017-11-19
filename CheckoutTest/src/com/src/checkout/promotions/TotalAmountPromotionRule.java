package com.src.checkout.promotions;

import java.util.Set;

import com.src.checkout.product.PurchasedProduct;

public class TotalAmountPromotionRule extends PromotionRule {

	private double minAmountNeeded; 
	private double discountToBeInPerc = 0.0d;

	public TotalAmountPromotionRule(double minAmountNeeded, double discountToBeInPerc) {
		this.minAmountNeeded = minAmountNeeded;
		this.discountToBeInPerc = discountToBeInPerc;
	}

	@Override
	public double apply(Set<PurchasedProduct> products) {
		Double totalBillAmount = products.stream().mapToDouble(p -> (p.getOriginalPrice()*p.getCountOfPuchased())).sum();
		double totalDiscountApplied = 0.0;
		if (totalBillAmount >= minAmountNeeded) {
			totalDiscountApplied = (totalBillAmount*discountToBeInPerc)/100;
		}
		return totalDiscountApplied;
	}

}
