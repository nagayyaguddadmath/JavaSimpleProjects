package com.model;

import java.math.BigDecimal;

public class Lender implements Comparable<Lender> {

	static int idCount = 1;
	private int lenderId;
	private String name;
	private BigDecimal rateOfInterest;
	private BigDecimal amount;

	public Lender(String lenderDeatils) {
		String[] arrLender = lenderDeatils.split(",");
		this.lenderId = idCount++;
		this.name= arrLender[0];
		try {
			this.rateOfInterest = new BigDecimal(arrLender[1]);
			this.amount = new BigDecimal(arrLender[2]);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("Error, Given market file content is not valid."); 
		}

	}

	public Lender(Lender lender, BigDecimal lendingAmount) {
		this.lenderId = lender.getLenderId();
		this.name= lender.getName();
		this.rateOfInterest = lender.getRateOfInterest();
		this.amount = lendingAmount;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getRateOfInterest() {
		return rateOfInterest;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public int getLenderId() {
		return lenderId;
	}

	@Override
	public int compareTo(Lender lender) {
		int compare = this.rateOfInterest.compareTo(lender.rateOfInterest);
		if (compare == 0) {
			return this.amount.compareTo(lender.amount) * -1;
		}
		return compare;
	}
}
