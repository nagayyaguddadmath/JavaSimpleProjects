package com.sample.run;

import java.util.HashMap;
import java.util.Map;

public class SampleChild extends SampleParent {

	public String child = "Child";
	
    public SampleChild() {
//        System.out.println("Child Constructor");
    }  
    
//	{
//        System.out.println("Child initialisation block");
//    }
//	static {
//        System.out.println("Child static block");
//    }

	
	public static void main(String[] args) {
		
		
		Map<SampleChild, SampleParent> hashMap = new HashMap<SampleChild, SampleParent>();
		SampleChild child = new SampleChild();
		SampleParent parent = new SampleParent();
		hashMap.put(child, parent);
//		System.out.println("Before makign null:" + hashMap.size() );
		
		for (SampleChild schild:hashMap.keySet()) {
			System.out.println("before schild:" + schild.child);
		}
		child= null;
		for (SampleChild schild:hashMap.keySet()) {
			System.out.println("after schild:" + schild.child);
		}
//		System.out.println("After makign null:" + hashMap.size());
		
		/*String strWelcome = "Welcome to java";
		System.out.println(strWelcome);*/
		
//		new SampleChild();
	}

}
