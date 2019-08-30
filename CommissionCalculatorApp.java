package com.company;
public class CommissionCalculation {


    // Method to calculate commission
    public double CalculateCommission(double annualSales, double salesTarget, double commissionRate, double incentiveRate, double acceleratedRate) {
        // Set initial commission earned to 0
        double commissionAccum = 0;

        // If annual sales is below than 80% of sales target
        if (annualSales < (salesTarget * incentiveRate)) {
            commissionAccum = 0;
        }
        // If annual sales meet 80% of the sales target
        else if (annualSales <= salesTarget) {
            commissionAccum = annualSales * commissionRate;
        }
        // If total sales exceed the sales target
        else if (annualSales > salesTarget) {
            double salesDifference = annualSales - salesTarget;
            commissionAccum = (annualSales * commissionRate) + (salesDifference * acceleratedRate);
        }

        return commissionAccum;


    }
}
