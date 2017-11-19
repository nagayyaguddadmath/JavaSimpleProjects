package com.src.checkout.promotions;

import java.util.Set;

import com.src.checkout.product.Product;
import com.src.checkout.product.PurchasedProduct;

public class ItemBasedPromotionRule extends PromotionRule {

	private String productCode;
	private int minCountNeeded;
	private double discountInPerc = 0.0d;

	public ItemBasedPromotionRule(String productCode, int minCountNeeded, double discountInPerc) {
		this.productCode = productCode;
		this.minCountNeeded = minCountNeeded;
		this.discountInPerc = discountInPerc;
	}

	@Override
	public double apply(Set<PurchasedProduct> products) {
		Product foundProduct = products.stream().filter(p -> p.getProductCode().equals(productCode)).findFirst().orElse(null);
		//found product should be only one as we use set collection type
		double totalDiscountApplied = 0.0;
		if (foundProduct != null) {
			if (((PurchasedProduct)foundProduct).getCountOfPuchased() >= minCountNeeded) {
				totalDiscountApplied =  ((foundProduct.getOriginalPrice() * discountInPerc)/100) * ((PurchasedProduct)foundProduct).getCountOfPuchased();
			}
		}
		return totalDiscountApplied;
	}

}
