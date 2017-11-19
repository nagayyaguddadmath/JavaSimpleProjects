package com.sample.run;

public class PrimeCheck {

	public static void main(String[] args) {
	int m =17;
	int n = m/3;
	System.out.println(n);
	
	
	int result = 0;
    String upperRoman = input.toUpperCase(); //case-insensitive
    for (int i = 0; i < upperRoman.length() - 1; i++) {//loop over all but the last character
        if (decodeRomanChar(upperRoman.charAt(i)) < decodeRomanChar(upperRoman.charAt(i + 1))) {
            result -= decodeRomanChar(upperRoman.charAt(i));
        } else {
            result += decodeRomanChar(upperRoman.charAt(i));
        }
    }
    result += decodeRomanChar(upperRoman.charAt(upperRoman.length() - 1));
    return result;
	}
}
