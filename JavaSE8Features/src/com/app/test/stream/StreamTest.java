package com.app.test.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) {
		List<String> arrNames = Arrays.asList("A", "BC", "CD", "D");
		arrNames.stream().filter(p -> {if (p.length() > 1) return true; return false;}
				).forEach(p -> System.out.println(p));

		arrNames.stream().forEach(p -> System.out.println(p));

		arrNames.stream().filter(p -> { return true; }
				).forEach(p -> System.out.println(p));

	
	}

}
