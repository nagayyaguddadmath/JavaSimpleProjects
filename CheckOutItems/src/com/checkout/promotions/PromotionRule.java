package com.checkout.promotions;

import java.util.Set;

import com.checkout.product.Product;

public abstract class PromotionRule {

	protected int applyOrder = 0;
	
	protected double totalDiscountApplied = 0.0;
	
	public abstract void apply(Set<Product> products);

	public int getApplyOrder() {
		return applyOrder;
	}

	public double getTotalDiscountApplied() {
		return totalDiscountApplied;
	}

}