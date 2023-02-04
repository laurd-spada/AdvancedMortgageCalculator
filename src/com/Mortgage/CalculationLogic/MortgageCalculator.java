package com.Mortgage.CalculationLogic;

public class MortgageCalculator {
    private int principal;
    private float annualInterestRate;
    private byte period;
    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }
    public double calculateMortgage() {
        float monthlyRate = (annualInterestRate / 100) / 12;
        float numberOfPayment = period * 12;
        return principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayment) / (Math.pow(1 + monthlyRate, numberOfPayment) - 1));
    }
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = (annualInterestRate / 100) / 12;
        float numberOfPayment = period * 12;
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayment) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);
        return balance;
    }
    public short getPeriod() {
        return period;
    }
}
