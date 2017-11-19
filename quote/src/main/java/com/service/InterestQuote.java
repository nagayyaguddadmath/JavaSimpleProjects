package com.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import com.model.Lender;

public class InterestQuote {

	private Set<Lender> selectedLenders = new HashSet<Lender>();
	private BigDecimal monthlyRepayment;
	private BigDecimal interestApplied;

	public static final int NOOFMONTHS = 36;
	private static final int PERYEARCOMPOUND = 12;
	private int DIVIDEROUNDING = 10;

	public final static String highAmountError = "Market does not have sufficient offers from lenders to satisfy the loan";

	public Set<Lender> getSelectedLenders() {
		return selectedLenders;
	}

	public BigDecimal getMonthlyRepayment() {
		return monthlyRepayment;
	}

	public boolean calculateInterestQuote(BigDecimal initalAmount, Set<Lender> lendersList) {
		selectLenders(initalAmount, lendersList);
		interestApplied = getAverageLendersRate(initalAmount);

		double period = (double) 1/PERYEARCOMPOUND;
		double effectiveMonthlyRate = Math.pow((1 + interestApplied.doubleValue()), period) - 1;
		// yearly factor =  (1-(1+r)^-n)/r
		double yearlyFactor = (1 - Math.pow((1 + effectiveMonthlyRate), -(NOOFMONTHS))) / effectiveMonthlyRate;

		monthlyRepayment = initalAmount.divide(BigDecimal.valueOf(yearlyFactor), DIVIDEROUNDING, RoundingMode.HALF_UP);
		//        BigDecimal totalRepayment = monthlyRepayment.multiply(BigDecimal.valueOf(NOOFMONTHS));

		return true;
	}

	private void selectLenders(BigDecimal initalAmount, Set<Lender> lendersList) {
		for (Lender lender: lendersList) {
			int compare = initalAmount.compareTo(lender.getAmount());
			if (compare <= 0) {
				selectedLenders.add(new Lender(lender, initalAmount));
				return;
			} else {
				selectedLenders.add(new Lender(lender, lender.getAmount()));
				initalAmount = initalAmount.subtract(lender.getAmount());
			}
		}
		if (initalAmount.compareTo(BigDecimal.ZERO) > 0) {
			throw new IllegalArgumentException(highAmountError);
		}
	}

	public BigDecimal getAverageLendersRate(BigDecimal initalAmount) {
		BigDecimal[] totalWithCount
		= selectedLenders.stream()
		.filter(l -> l.getRateOfInterest() != null)
		.map(l -> new BigDecimal[]{l.getRateOfInterest().multiply(l.getAmount().divide(initalAmount, DIVIDEROUNDING, RoundingMode.HALF_UP)), BigDecimal.ONE})
		.reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)})
		.get();

		return totalWithCount[0];
	}

	public BigDecimal getInterestApplied() {
		return interestApplied;
	}

	public String printInterestRate(){
		return getInterestApplied().multiply(BigDecimal.valueOf(100)).setScale(1, BigDecimal.ROUND_HALF_UP).toString();
	}

	public String printMonthlyAmount(){
		return getMonthlyRepayment().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

	public String printTotalAmount(){
		return getMonthlyRepayment().multiply(BigDecimal.valueOf(InterestQuote.NOOFMONTHS)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}

}
