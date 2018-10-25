/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prsystem;

/**
 *
 * @author ShimonMoyal
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PRSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Employee> arrEmp = new ArrayList<Employee>();
        String varCount = "N";
        byte menuOption = 0;
        do{
                menuOption = showMenu();
            switch (menuOption) {
                case 1:
                    FullTime ft;
                    ft = readNewFullTime();
                    addEmployee(arrEmp, ft);
                    break;
                case 2:
                    PartTime pt;
                    pt = readNewPartTime();
                    addEmployee(arrEmp, pt);
                    break;
                case 3:
                    calcPayroll(arrEmp);
                    break;
                default:
                    break;
                    
            }
        } while (menuOption != 4);
    }
     
    public static FullTime readNewFullTime(){
        int id=0;
        String name=null;
        double sal = 0.0;
        double hourAndHalf = 0.0;
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: "); id = kbd.nextInt();
        System.out.print("\nEnter Name: "); name=kbd.next();
        System.out.print("\nEnter Salary: "); sal=kbd.nextDouble();
        System.out.print("\nEnter Bonus: "); hourAndHalf = kbd.nextDouble();
        
        FullTime ftl= null;
        ftl = new FullTime(id,name,sal,hourAndHalf,getVehicle());
        return ftl;
    }
    public static PartTime readNewPartTime(){
        
        int id = 0;
        String name=null;
        double rate=0.0;
        double hoursWorked = 0.0;
        
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter Id: "); id = kbd.nextInt();
        System.out.print("\nEnter Name "); name=kbd.next();
        System.out.print("\nEnter Salary "); rate=kbd.nextDouble();
        System.out.print("\nEnter Bonus "); hoursWorked = kbd.nextDouble();
        
        Vehicle v1 = getVehicle();
        PartTime pt1 = null;
        pt1 = new PartTime(id,name,rate,hoursWorked,v1);
        
        return pt1;
        
        
    } 
    
    public static byte showMenu()
    {
        byte menuOption = 0;
        Scanner kbd = new Scanner(System.in);
        
        System.out.println(""
        + "*****************************/"
        + "\n/* 1. Add FullTime        */"
        + "\n/* 2. AddPartTime         */"
        + "\n/* 3. Calculate Payroll   */"
        + "\n/* 4. Exit                */"
        + "\n/**************************/");
    System.out.print("Input: ");  menuOption = kbd.nextByte();
    
    return menuOption;
        
    }
    
    public static Vehicle getVehicle(){
        
        Scanner kbd = new Scanner(System.in);
        String hasVehicle = "N";
        
        System.out.print("\nDoes this employee have a vehicle Y/N : \nInput : ");
        hasVehicle = kbd.next();
        
        if (hasVehicle.equalsIgnoreCase(("Y"))){
            
            System.out.print("\nEnter plate number: "); String auxPlate = kbd.next();
            System.out.print("\nEnter vehicle colour: "); String auxColour = kbd.next();
            return (new Vehicle(auxPlate, auxColour));
        }
        else{
            return(null);
        }
    }
    
    public static void addEmployee(ArrayList<Employee> pArrEmp,Employee pEmp)
    {
        pArrEmp.add(pEmp);
    }
    
    public static void calcPayroll(ArrayList<Employee> pArrEmp){
        double totalCompanyPay = 0.0;
        double individualPay;
        
            for(int i=0; i<pArrEmp.size(); i++){
                System.out.println("\n***************************");
                individualPay=(pArrEmp.get(i).calculatePay());
                Vehicle v=(pArrEmp.get(i).getVehicle());
                String hasVehicle;
                
                if (v == null)
                    hasVehicle = "No";
                else
                    hasVehicle = "Yes";
                
                System.out.println("Employee Name: " + (pArrEmp.get(i).getName()));
                System.out.println("Has Vehicle: " + hasVehicle);
                
                if (v != null){
                    
                   System.out.println("Plate Number: " + v.getPlateNumber());
                   System.out.println("Colour:" + v.getColour());
                   
                }
                
                System.out.println("Take Home Pay: " + individualPay);
                
                totalCompanyPay = totalCompanyPay + individualPay;
            }
            
        System.out.println("-------------\nTotal payroll of company: " + totalCompanyPay + "\n--------");
    }
}
