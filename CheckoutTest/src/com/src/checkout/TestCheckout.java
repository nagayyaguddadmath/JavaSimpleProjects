package com.src.checkout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.src.checkout.product.Product;
import com.src.checkout.product.PurchasedProduct;
import com.src.checkout.promotions.ItemBasedPromotionRule;
import com.src.checkout.promotions.PromotionRule;
import com.src.checkout.promotions.TotalAmountPromotionRule;

public class TestCheckout {


	public static void main(String[] args) {

		List<Product> products = new ArrayList<Product>();
		Set<PromotionRule> promotionalRules = new HashSet<PromotionRule>();

		promotionalRules.add(new TotalAmountPromotionRule(60d, 10d));
		promotionalRules.add(new ItemBasedPromotionRule("001", 2, ((9.25 - 8.5)*100)/9.25));

		products.add(new Product("001", "Travel Card Holder", 9.25d));
		products.add(new Product("002", "Personalised cufflinks", 45.00d));
		products.add(new Product("003", "Kids T-shirt", 19.95d));


		System.out.println("Basket: 001,002,003 :: ");
		Checkout checkout1 = new Checkout(promotionalRules);
		PurchasedProduct item1 = new PurchasedProduct(products.get(0));
		PurchasedProduct item2 = new PurchasedProduct(products.get(1));
		PurchasedProduct item3 = new PurchasedProduct(products.get(2));

		//Basket: 001,002,003 ::
		checkout1.scan(item1);
		checkout1.scan(item2);
		checkout1.scan(item3);
		System.out.println("Expected " + 66.78d + " and Actual is:" + checkout1.total());

		System.out.println("Basket: 001,003,001 ::");
		Checkout checkout2 = new Checkout(promotionalRules);
		PurchasedProduct item4 = new PurchasedProduct(products.get(0));
		//		PurchasedProduct item5 = new PurchasedProduct(products.get(1));
		PurchasedProduct item6 = new PurchasedProduct(products.get(2));

		//Basket: 001,002,003 ::
		checkout2.scan(item4);
		checkout2.scan(item6);
		checkout2.scan(item4);
		System.out.println("Expected " + 66.78d + " and Actual is:" + checkout2.total());



		System.out.println("Basket: 001,002,001,003 :: ");
		Checkout checkout3 = new Checkout(promotionalRules);
		PurchasedProduct item7 = new PurchasedProduct(products.get(0));
		PurchasedProduct item8 = new PurchasedProduct(products.get(1));
		PurchasedProduct item9 = new PurchasedProduct(products.get(2));

		//Basket: 001,002,001,003 :: 
		checkout3.scan(item7);
		checkout3.scan(item8);
		checkout3.scan(item7);
		checkout3.scan(item9);
		System.out.println("Expected " + 73.76d + " and Actual is:" + checkout3.total());
		System.exit(0);
	}
}
