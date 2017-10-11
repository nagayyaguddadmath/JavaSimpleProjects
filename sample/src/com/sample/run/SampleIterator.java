package com.sample.run;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class SampleIterator {

	public static void main (String[] args) {
		ConcurrentHashMap<String,String> premiumPhone = 
				new ConcurrentHashMap<String,String>();
				premiumPhone.put("Apple", "iPhone");
				premiumPhone.put("HTC", "HTC one");
				premiumPhone.put("Samsung","S5");

				Iterator iterator = premiumPhone.keySet().iterator();
				System.out.println(premiumPhone);
				while (iterator.hasNext())
				{
				System.out.println(premiumPhone.get(iterator.next()));
//				premiumPhone.remove("HTC");
				iterator.remove();
				}
				System.out.println(premiumPhone);
	}
}
