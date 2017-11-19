package com.sample.run;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompoundInterest{
    private static Transformer<BigDecimal> floor   = new BigDecToDiscreteViaFloor();
    private static Transformer<BigDecimal> ceil    = new BigDecToDiscreteViaCeil();
    private static Transformer<BigDecimal> round   = new BigDecToDiscreteViaRound();
    private static Transformer<BigDecimal> i       = new BigDecIdentity();

    public static void main(String[] args){

        BigDecimal initialInvestment = new BigDecimal("1000");
        BigDecimal annualRate = new BigDecimal("0.070");
        int compoundingPeriodsPerYear = 12;
        int years = 10;

        BigDecimal test  = new BigDecimal("10.12345");
        BigDecimal testA = new BigDecimal("10.105");
        BigDecimal testB = new BigDecimal("10.115");

        System.out.println("To get some confidence in our Transformers:");
        System.out.println(test  + " via Floor: "    + floor.transform(test));
        System.out.println(test  + " via Ceil: "     + ceil.transform(test));
        System.out.println(test  + " via Round: "    + round.transform(test));
        System.out.println(testA + " via Round: "    + round.transform(testA));
        System.out.println(testB + " via Round: "    + round.transform(testB));
        System.out.println(test  + " via Identity: " + i.transform(test));

        System.out.println();

        BigDecimal correct  = futureValue(initialInvestment, annualRate, compoundingPeriodsPerYear, years, i);
        BigDecimal viaFloor = futureValue(initialInvestment, annualRate, compoundingPeriodsPerYear, years, floor);
        BigDecimal viaCeil  = futureValue(initialInvestment, annualRate, compoundingPeriodsPerYear, years, ceil);
        BigDecimal viaRound = futureValue(initialInvestment, annualRate, compoundingPeriodsPerYear, years, round);

        System.out.println( "What is the future value of $" + initialInvestment + 
                            " invested at an annual rate of " + annualRate +
                            " compounded " + compoundingPeriodsPerYear + " time(s) per year for " +
                            years + " years?\n");

        //Consider $1M invested for 10 years at 7.125 % interest,
        //compounded quarterly calculated with decimals
        System.out.println( "'Correct' value (to two decimal places):" + round.transform(correct) + "\n");

        //Consider the same using integers (where integers are obtained
        //via the floor function on decimals)
        System.out.println("Using floor (to two decimal places):" + round.transform(viaFloor) + "\n");

        //Consider the same using integers (where integers are obtained
        //via the ceiling function on decimals)
        System.out.println("Using ceiling (to two decimal places):" + round.transform(viaCeil) + "\n");

        //Consider the same using integers (where integers are obtained
        //via the rounding)
        System.out.println("Using round (to two decimal places):" + round.transform(viaRound) + "\n");

    }

    public static BigDecimal futureValue(   BigDecimal initialInvestment,
                                            BigDecimal annualRate,
                                            int compoundingPeriodsPerYear,
                                            int years,
                                            Transformer<BigDecimal> t) {

        return  t.transform(initialInvestment).
                multiply(
                    BigDecimal.ONE.
                    add(
                        t.transform(annualRate).
                        divide(
                            new BigDecimal(compoundingPeriodsPerYear)
                        )
                    ).pow( (compoundingPeriodsPerYear * years ) )
               );
    }

    private static interface Transformer<T> {
        public T transform(T t);
    }

    private static class BigDecToDiscreteViaFloor implements Transformer<BigDecimal> {
        public BigDecimal transform(BigDecimal d) {
            return d.divide(BigDecimal.ONE, 2, RoundingMode.FLOOR);
        }
    }

    private static class BigDecToDiscreteViaCeil implements Transformer<BigDecimal> {
        public BigDecimal transform(BigDecimal d) {
            return d.divide(BigDecimal.ONE, 2, RoundingMode.CEILING);
        }
    }

    private static class BigDecToDiscreteViaRound implements Transformer<BigDecimal> {
        public BigDecimal transform(BigDecimal d) {
            return d.divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN);
        }
    }

    private static class BigDecIdentity implements Transformer<BigDecimal> {
        public BigDecimal transform(BigDecimal d) {
            return d;
        }
    }
}