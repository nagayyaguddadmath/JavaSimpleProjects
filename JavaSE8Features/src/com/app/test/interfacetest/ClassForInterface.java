package com.app.test.interfacetest;

public class ClassForInterface implements Interface1{

	public void apply1 (String strTest) {
		System.out.println("inside class");
	}
	
	static public  void main(String[] args) {
		ClassForInterface testClass = new ClassForInterface();
		testClass.apply1("test");
	}
}
