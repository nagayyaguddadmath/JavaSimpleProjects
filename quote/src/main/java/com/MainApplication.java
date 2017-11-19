package com;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Set;

import com.model.Lender;
import com.service.InterestQuote;
import com.service.ReadMarkerFile;

public class MainApplication {


	public static void main(String[] args) throws IOException, ParseException {

		validateArgParams(args);

		ReadMarkerFile readFile = new ReadMarkerFile();
		Set<Lender> lenders = readFile.readLenderFromFile(args[0]);
		InterestQuote quote = new InterestQuote();
		BigDecimal initalAmount = new BigDecimal(args[1]);
		quote.calculateInterestQuote(initalAmount, lenders);

		printQuote(quote, initalAmount);
	}

	private static void printQuote(InterestQuote quote, BigDecimal initalAmount) {
		System.out.println(REQAMOUNTSTRING + initalAmount.toString());
		System.out.println(RATESTRING + quote.printInterestRate() + "%");
		System.out.println(MONTHLYAMOUNTSTRING + quote.printMonthlyAmount());
		System.out.println(TOTAAMOUNTSTRING + quote.printTotalAmount());
	}

	private static void validateArgParams(String[] args) {
		if (args.length != 2) {
			throw new IllegalArgumentException(NOTVALIDARG +args); 
		}
		try {
			BigDecimal amount = new BigDecimal(args[1]);
			if (checkvalidAmount(amount)) {
				throw new IllegalArgumentException(NOTVALIDAMOUNT +amount.toString()); 
			}
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException(NOTVALIDARG +args[1]); 
		}
	}

	private static boolean checkvalidAmount(BigDecimal amount) {
		return (amount.compareTo(BigDecimal.valueOf(1000)) < 0 || amount.compareTo(BigDecimal.valueOf(15000)) > 0 ||
				!amount.remainder(BigDecimal.valueOf(100)).equals(BigDecimal.ZERO));
	}
	
	public static final String REQAMOUNTSTRING = "Requested amount: £";
	public static final String RATESTRING = "Rate: ";
	public static final String MONTHLYAMOUNTSTRING = "Monthly repayment:";
	public static final String TOTAAMOUNTSTRING = "Total repayment:";
	public static final String NOTVALIDARG = "Not a valid argument:";
	public static final String NOTVALIDAMOUNT = "Not a valid amount: ";

}
