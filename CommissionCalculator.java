/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissioncalculator;
import java.util.*;
import java.text.DecimalFormat;
/**
 *
 * @author phora
 */
public class CommissionCalculator {

        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //Declarations
        double[] annualSales= new double[2]; //Declaring and setting Annual Sales
        double commissionRate = .07; //Declaring and setting Commission rate 7%
        double salary = 12000.0;//Salary base pay is $12,000
        double incentiveRate = .08;//Incentive Rate after target is reached
        double target = 120000.0;//Sales Target $120,000
        double accCommissionRate = 1.25;//Commission Rate in excess of Sales Target
        int i;// variable for the array
        String[] Name= new String[2];//variable to hold Sales People Names
        CommissionCalculatorApp c = new CommissionCalculatorApp();//Calculation object to calculate the commissions
        
        double [] TotalCompensation = new double[2];
        Scanner s = new Scanner(System.in);//Scanner object to recieve User Input
        DecimalFormat df = new DecimalFormat("###,###.00");
        
        
         String Salesperson[]=new  String[3];
         for(i=0;i<2;i++){
             System.out.println("Enter the Name of Each Sales Associate: ");
             Name[i] = s.nextLine();
             System.out.print("Enter your Total Annual Sales Amount: $");//Prompt user for input
             annualSales[i] = s.nextDouble();//Collect User Input
             double totalComm = c.commissionAmount(annualSales[i],target,accCommissionRate,commissionRate,incentiveRate);
             TotalCompensation[i] = totalComm+ salary;//Calculate total amount made
             
         }
        
        List<String> People= new ArrayList<>();
        
         
         //Calculation Constructor
        
        
        
        //Set the Maximum Potential Sales
        double potentialSalesMax =annualSales[i] +(annualSales[i] * 0.5);
        //Set the Minimum Potential sales 
        double potentialSalesMin =annualSales[i];
        //Print out of Compsenation of Complete Sales
        System.out.println("The Annual Sales: $ " + df.format(annualSales[i]));
        System.out.println("Total Commission is: $ " + df.format(totalComm));
        System.out.println("The Current Commission rate is: " + commissionRate+ "%");
        System.out.println("The Total Amount made is: $" + df.format(TotalCompensation[i]));
        System.out.println("The base Salary is : $" + df.format(salary));
        System.out.println("The Accelerated Rate is: " + accCommissionRate +"%");
        System.out.println("The Incentive rate is: " + incentiveRate + "%");
        
        // Output the Potential Annual Compensation table
        System.out.println("Total Sales\t\tTotal compensation");
        while (potentialSalesMin <= potentialSalesMax) {
            System.out.println(df.format(potentialSalesMin) + "\t\t"
                    + df.format(c.commissionAmount(potentialSalesMin, target, commissionRate, incentiveRate, accCommissionRate) + salary));
            potentialSalesMin = potentialSalesMin + 5000;
        } 
    }
    
}
