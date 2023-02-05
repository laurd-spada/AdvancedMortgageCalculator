package com.Mortgage.CalculationLogic;

public class MortgageCalculator {
    private int principal;
    private float annualInterestRate;
    private byte period;
    public MortgageCalculator(int principal, float annualInterestRate, byte period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }
    public double calculateMortgage() {
        float monthlyRate = getMonthlyRate();
        float numberOfPayment = getNumberOfPayment();
        return principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayment) / (Math.pow(1 + monthlyRate, numberOfPayment) - 1));
    }
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyRate();
        float numberOfPayment = getNumberOfPayment();
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayment) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);
        return balance;
    }
    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayment()];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);
        return balances;
        }
    private int getNumberOfPayment() {
        return period * 12;
    }

    private float getMonthlyRate() {
        return (annualInterestRate / 100) / 12;
    }
}
