package com.Mortgage;

import com.Mortgage.CalculationLogic.MortgageCalculator;
import com.Mortgage.Console.Console;
import com.Mortgage.Report.MortgageReport;
public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Please enter your Principal ($1k - $1m): ", 1_000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Enter your Annual Interest Rate: ", 1,30);
        byte period = (byte) Console.readNumber("Enter the period(Years) to pay back: ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterestRate, period);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}