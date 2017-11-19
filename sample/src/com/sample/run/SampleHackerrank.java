package com.sample.run;

import java.util.Scanner;

public class SampleHackerrank {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String A=sc.next();
		/* Enter your code here. Print output to STDOUT. */
		boolean isPalindrome = true;
		for (int i=0 ; i<(A.length()/2);i++) {
			if (A.charAt(i) != A.charAt(A.length() - 1 -i)) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
