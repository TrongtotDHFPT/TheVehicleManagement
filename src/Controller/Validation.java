/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class Validation {
    public static boolean checkPrice(String x) {
        try {
            Float.parseFloat(x);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return false;
        }
    }
    
    public static boolean checkProductYear(String x){
        try{
            int year =  Integer.parseInt(x);
            return year >= 1800 && year <= 2024;
        }catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            return false;
        }
    }
    public static float checkPriceUp(){
        String newPrice;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter new price :");
            newPrice = sc.nextLine();
            if(newPrice.isEmpty()){
                flag = true;
                break;
            }          
        }while(!Validation.checkPrice(newPrice));
        
        if(flag){
            return 0;
        }
        return Float.parseFloat(newPrice);
    }
    
    public static int checkProductYearUp(){
        String newProductYear = "" ;
        Scanner sc = new Scanner(System.in);
        boolean check = false;
      
        do{
            System.out.print("Enter new ProductYear : ");
            newProductYear = sc.nextLine();
            if(newProductYear.isEmpty()){
            check = true;
        }
        }while(!Validation.checkProductYear(newProductYear));
        if(check){
            return 0;
        }
        return Integer.parseInt(newProductYear);
    }
    
    
}
