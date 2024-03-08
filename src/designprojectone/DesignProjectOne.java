/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.util.Scanner;
/***************************************************
*
*  Program: Tech Fair Cost Calculator
*  Author: Andrew
*  Date: 03/07/24
*  Description: Calculates the materials cost/student for the RHHS Technology Science Fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
* Number of arduino orders
* Number of raspberry pi orders
* Number of VR orders
*
*PROCESSING:
* Calculate total number of orders
* Calculate cost for fixed costs
*   - if totalOrders > 100, fixedCosts = totalOrders*50*0.95
*   - else fixedCost = totalOrders*50 
* Calculate additional cost of arduino kits
*   - if arduinoOrders > 15, arduinoCost = arduinoOrders*9
*   - else arduinoCost = arduinoOrders*10
* Calculate additional cost of raspberry pi kits
*   - if raspPiOrders > 20, raspPiCost = raspPiOrders*12
*   - else raspPiCost = raspPiOrders*15
* Calculate additional cost of VR kits
    - vrCost = vrOrders*20
* Calculate total costs
*   - totalCost = fixedCost + arduinoCost + raspPiCost + vrCost
* Calculate average cost per student
*   - avgCost = totalCost/totalOrders
* Output results
*
*OUTPUT:
* Total cost for materials
* Average cost per student
***************************************************/
  
/**************** TEST CASES ************************
*Test      Input (arduino, raspPi, vr)  Desired Ouput (avgCostRounded)  Actual Output     
* 1                 0,0,0                          0                       0      
* 2                 10,10,10                      65                       65
* 3                 50,50,50                     61.17                    61.17
* 4                 15,20,0                      62.86                    62.86
* 5                 16,21,0                      60.70                    60.7
* 6                 20,0,20                       64.5                     64.5
* 
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
        //define constants
        Scanner keyboard = new Scanner(System.in);
        
        final double baseCost = 50.00;
        final int discountCutoff = 100;
        final double discountedRate = 0.95;
        
        final int arduinoCutoff = 15;
        final int raspPiCutoff = 20;
        final double vrPrice = 20.00;
        
        //define variables
        double fixedCost;
        double arduinoCost;
        double raspPiCost;
        double vrCost;
        double totalCost;
        double avgCost;
        double avgCostRounded;
        
        //ask for inputs (number of arduino, raspPi, vr orders)
        System.out.println("Enter the number of Arduino orders:");
        int arduinoOrders = keyboard.nextInt();
        
        System.out.println("Enter the number of Raspberry PI orders:");
        int raspPiOrders = keyboard.nextInt();
        
        System.out.println("Enter the number of VR orders:");
        int vrOrders = keyboard.nextInt();
        
        //calculate total number of orders
        int totalOrders = arduinoOrders + raspPiOrders + vrOrders;
        
        //calculate costs
        if (totalOrders > 0) {
            
            //calculate fixed costs
            if (totalOrders > discountCutoff) {
                fixedCost = totalOrders*baseCost*discountedRate;
            } 
            else {
                fixedCost = totalOrders*baseCost;
            }
            
            //calcualte addiontial cost of ardiunos
            if (arduinoOrders > arduinoCutoff) {
                arduinoCost = arduinoOrders*9.00;
            } 
            else {
                arduinoCost = arduinoOrders*10.00;
            }
            
            //calcualte addiontial cost of raspberry pis
            if (raspPiOrders > raspPiCutoff) {
                raspPiCost = raspPiOrders*12.00;
            } 
            else {
                raspPiCost = raspPiOrders*15.00;
            }
            
            //calculate additional cost of vrs
            vrCost = vrOrders*vrPrice;
            
            //calculate total cost + cost/student
            totalCost = fixedCost + arduinoCost + raspPiCost + vrCost;
            avgCost = totalCost/totalOrders;
            avgCostRounded = Math.round(avgCost*100.0)/100.0;
        }
        else {
            totalCost = 0;
            avgCost = 0;
            avgCostRounded = 0;
        }
        
        //output results
        System.out.println('\n');
        System.out.println("The total cost for all the projects is $" + totalCost);
        System.out.println("The cost per student is $" + avgCostRounded);       
    }
    
}
