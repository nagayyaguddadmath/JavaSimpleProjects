package com.sample.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SampleIterator2 {

	public static void main (String[] args) {
		Map<Integer,String> map=new HashMap<Integer,String>();//new ConcurrentHashMap<Integer,String>();

		map.put(1, "Sachin");

		map.put(2, "Sachin");

		map.put(3, "Sachin");

		map.put(4, "Sachin");

		Iterator<Integer> itr=map.keySet().iterator();
		System.out.println(map);

		while(itr.hasNext()){
			itr.next();
			itr.remove();

		}
		System.out.println(map);

	}
}
