package com.sample.hashmap;

import java.util.ArrayList;

public class HashSetT<T> {

	private int sizeOfHash = 16;
	private ArrayList<T> hashSet = new ArrayList<T>(sizeOfHash);
	private int currentSize = 0;
	
	public void add(T obj){
		if (currentSize == sizeOfHash) {
			sizeOfHash = sizeOfHash * 2;
			rearrangeExistValues();
		}
		if (hashSet.get(obj.hashCode()%sizeOfHash) == null) {
			hashSet.set((obj.hashCode()%sizeOfHash), obj);
			currentSize++;
		} else {
			
		}
	}
	
	private void rearrangeExistValues() {
		// TODO Auto-generated method stub
		
	}

	public boolean remove(T obj) {
		hashSet.remove((obj.hashCode()%sizeOfHash));
		return true;
		
	}
	
//	public T getNext()
}
