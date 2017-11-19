package com.checkout;

import java.util.HashSet;
import java.util.Set;

import com.checkout.product.Product;
import com.checkout.product.PurchasedProduct;
import com.checkout.promotions.PromotionRule;

public class Checkout {

	private Set<Product> scannedProducts = new HashSet<Product>();
	
	private double totalAmountToPay = 0.0d;

	//we can either apply promotions in the same way as they have been added OR we can take order as priority to apply promotions
	//I am assuming it will be added in the same order as they would be applied
	private Set<PromotionRule> promotionalRules = new HashSet<PromotionRule>();

	public Checkout(Set<PromotionRule> promotionalRules) {
		this.promotionalRules = promotionalRules;
	}

	public void scan(Product purchasedProduct) {
		((PurchasedProduct)purchasedProduct).increaseCountBy(1);
		totalAmountToPay += purchasedProduct.getOriginalPrice();
		scannedProducts.add(purchasedProduct);
	}

	public double total() {
		for (PromotionRule promotion: promotionalRules) {
			promotion.apply(scannedProducts);
			totalAmountToPay = totalAmountToPay - promotion.getTotalDiscountApplied(); 
		}

		return totalAmountToPay;

	}
}