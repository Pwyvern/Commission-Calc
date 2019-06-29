/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissioncalculator;

/**
 *
 * @author phora
 */
public class CommissionCalculatorApp extends CommissionCalculator {
   //Commission Equation to calculate the amount of commission made
    
    public double commissionAmount(double annualSales, double commissionRate,double accCommissionRate, double target, double incentiveRate){
        //Intialize the commission and set it to 0
        double totalComm = 0;
        //Test for the Exceeding the target
        if(annualSales > target){
            double salesDifference = annualSales - target;
            totalComm = (annualSales * commissionRate)+(salesDifference * accCommissionRate);
           
        }else if(annualSales <= target){
           totalComm= annualSales * commissionRate;
           
        }else if(annualSales<(incentiveRate * target)){
            totalComm = 0;
            
        }
         return totalComm;
    }
    

    
}
