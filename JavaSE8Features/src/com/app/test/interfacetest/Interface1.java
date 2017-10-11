package com.app.test.interfacetest;

public interface Interface1 {
	default void apply(String strTest) {
		System.out.println("Insdie Interface:" + strTest);
	}
}
