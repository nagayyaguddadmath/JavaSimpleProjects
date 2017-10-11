package com.app.test.lamda;

import java.util.function.Consumer;
import java.util.function.Supplier;

import java.time.LocalDate;

public class Java8LamdaTest {

	public static void main(String[] args) {

		Consumer<String> cons = str -> { if (str == "Nagu") System.out.println(str);System.out.println("test");
		};
		cons.accept("Nagu");

		/*Supplier<Integer> supply  = () -> {System.out.println("Test"); return 5;};
		supply.get();
		*/
		LamdaInterfaceDouble lambdaDoubleAdd = (Double x, Double y) -> ( x + y);
		LamdaInterfaceDouble lambdaDoubleMult = (Double x, Double y) -> x * y;
		LamdaInterfaceDouble lambdaDoubleSub = (Double x, Double y) -> ( x - y);
		LamdaInterfaceDouble lambdaDoubleDiv = (Double x, Double y) -> ( x / y);
		
		System.out.println(lambdaDoubleAdd.apply(2.0, 3.0));
		System.out.println(lambdaDoubleMult.apply(2.0, 3.0));
		System.out.println(lambdaDoubleSub.apply(2.0, 3.0));
		System.out.println(lambdaDoubleDiv.apply(2.0, 3.0));

		LamdaInterfaceInt lambdaInt = (int x, int y) -> { return x * y;};
		System.out.println(lambdaInt.apply(2, 3));


		
		
//		LocalDate lt1 =  LocalDate.of(2016, 12, 31);
//		LocalDate lt2 =  LocalDate.of(2016, 12, 30);
//        System.out.println( "Hello World!" + lt1.compareTo(lt2));
    }

}
