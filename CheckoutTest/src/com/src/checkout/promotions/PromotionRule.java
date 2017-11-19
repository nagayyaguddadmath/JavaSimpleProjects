package com.src.checkout.promotions;

import java.util.Set;

import com.src.checkout.product.PurchasedProduct;

public abstract class PromotionRule {


	public abstract double apply(Set<PurchasedProduct> products);

}