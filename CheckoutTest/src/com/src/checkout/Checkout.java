package com.src.checkout;

import java.util.HashSet;
import java.util.Set;

import com.src.checkout.product.PurchasedProduct;
import com.src.checkout.promotions.PromotionRule;

public class Checkout {

	private Set<PurchasedProduct> scannedProducts = new HashSet<PurchasedProduct>();

	private double totalAmountToPay = 0.0d;

	//we can either apply promotions in the same way as they have been added OR we can take order as priority to apply promotions
	//I am assuming it will be added in the same order as they would be applied
	private Set<PromotionRule> promotionalRules = new HashSet<PromotionRule>();

	public Checkout(Set<PromotionRule> promotionalRules) {
		this.promotionalRules = promotionalRules;
	}

	public void scan(PurchasedProduct purchasedProduct) {
		totalAmountToPay += purchasedProduct.getOriginalPrice();
		scannedProducts.add(purchasedProduct);
		((PurchasedProduct)purchasedProduct).increaseCountBy(1);
	}

	public double total() {
		for (PromotionRule promotion: promotionalRules) {
			totalAmountToPay = totalAmountToPay - promotion.apply(scannedProducts); 
		}

		return totalAmountToPay;

	}
}