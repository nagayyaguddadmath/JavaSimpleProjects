package com.checkout.promotions;

import java.util.Set;

import com.checkout.product.Product;
import com.checkout.product.PurchasedProduct;

public class ItemBasedPromotionRule extends PromotionRule {

	private Long productCode;
	private int minCountNeeded;
	private double discountInPerc = 0.0d;

	public void ItemDiscountPromotion(Long productCode, int minCountNeeded, double discountInPerc, int applyOrder) {
		this.productCode = productCode;
		this.minCountNeeded = minCountNeeded;
		this.discountInPerc = discountInPerc;
		this.applyOrder = applyOrder;
	}

	@Override
	public void apply(Set<Product> products) {
		Product foundProduct = products.stream().filter(p -> p.getProductCode().equals(productCode)).findFirst().orElse(null);
		//found product should be only one as we use set collection type
		if (foundProduct != null) {
			if (((PurchasedProduct)foundProduct).getCountOfPuchased() >= minCountNeeded) {
				totalDiscountApplied =  ((foundProduct.getOriginalPrice() * discountInPerc)/100) * minCountNeeded;
			}
		}
	}

}
