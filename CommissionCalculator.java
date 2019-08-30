
package com.company;
import java.util.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        DecimalFormat df= new DecimalFormat("000,000.00");

        //Base Salary
        double salary = 12000.0;

        //Convert 7% into a decimal
        double commissionRate = .07;

        //Sales Target to Reach is $120,000
        double salesTarget = 120000.0;

        //The incentive rate is 80%
        double incentiveRate = .8;

        //After exceeding Sales Target get Accelerated rate
        double acceleratedRate = 1.25;

        //Created Annual Compensation array
        double[] annualCompensation = new double[2];

        //Created Names array
        String[] name = new String[2];

        //Commission array created
        double[] commission = new double[2];

        //Created Annual Sales array
        double[] annualSales = new double[2];

        //Get input from user for annual sales of the sales person
        Scanner scan = new Scanner(System.in);

        //Collect User input
        double max = Double.NEGATIVE_INFINITY;

        for (int i= 0; i<2; i++) {
            //Input for Sales Person Name
            System.out.println("Enter Name: ");
            name[i] = scan.next();
            //User input for Annual Sales
            System.out.println("Enter Total Annual Sales: $");
            annualSales[i] = scan.nextDouble();
            //Calculate the annual compensation of the employees
            annualCompensation[i] = commission[i] + salary;
            //Calculate the average of the sales
            double average = annualCompensation[i] - annualCompensation[i];
            //Notify who is the lowest sales person
            if (annualCompensation[0] > annualCompensation[1]) {
                if (annualCompensation[0] > annualCompensation[1]) {
                    System.out.println(name[1] + " needs to make " + average + " to meet " + name[0]);
                }
            }
            //Calculate the Maximum annual compensation
            if (annualCompensation[i] > max) {
                max = annualCompensation[i];
            }
        }


            //Create commission calculation object
            com.company.CommissionCalculation comCalc = new com.company.CommissionCalculation();
            for(int i=0;i<2;i++){

            //Retrieve the commission earned from the CommissionCalculator
            double commissionAccum = comCalc.CalculateCommission(annualSales[i], salesTarget, commissionRate, incentiveRate, acceleratedRate);

            //Calculate the max value for the Potential Annual Compensation table
            double potentialSalesMax = annualSales[i] + (annualSales[i] * 0.5);

            //Set the min value for the Potential Annual Compensation table
            double potentialSalesMin = annualSales[i];

            //Output the Annual Salary of the Sales Person
            System.out.println("Annual Salary = " + df.format(salary));

            //Output the Commission Rate
            System.out.println("Commission Rate = " + commissionRate);

            //Output the Sales Incentive Rate
            System.out.println("Sales Incentive Rate = " + incentiveRate);

            //Output the Accelerated Commission Rate
            System.out.println("Accelerated Commission Rate" + acceleratedRate);

            //Output the Annual Sales of the Sales Person
            System.out.println("Annual Sales = " + df.format(annualSales[i]));

            //Output the Annual Sales Target of the Sales Person
            System.out.println("Annual Sales Target = " + df.format(salesTarget));

            //Output the Commission Earned
            System.out.println("Commission Earned = " + df.format(commissionAccum));

            //Output the Total Annual Compensation
            System.out.println("Annual Compensation = " + df.format(annualCompensation[i]));



            //Output the Potential Annual Compensation table
            System.out.println("Total Sales\t\tTotal Compensation");
            while (potentialSalesMin <= potentialSalesMax) {
                System.out.println(df.format(potentialSalesMin) + "\t\t" + df.format(comCalc.CalculateCommission(potentialSalesMin, salesTarget, commissionRate, incentiveRate, acceleratedRate) + salary));
                potentialSalesMin = potentialSalesMin + 5000;

            }
        }

    }
}
