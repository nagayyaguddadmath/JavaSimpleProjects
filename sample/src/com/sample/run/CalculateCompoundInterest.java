package com.sample.run;

public class CalculateCompoundInterest {

	public static void main(String[] args) {

		
		System.out.println("Interest at " + 36 + " months is " + getInterest(7/12,36,1000));
		System.out.println("Interest at " + 36 + " months is " + getInterest(6.9/12,36,480));
		System.out.println("Interest at " + 36 + " months is " + getInterest(7/12,36,520));
	}

	public static double getInterest(double rate, int time, double principal){
	    double multiplier = Math.pow(1.0 + rate/100.0, time) - 1.0;
	    return multiplier * principal;
	  }
}
