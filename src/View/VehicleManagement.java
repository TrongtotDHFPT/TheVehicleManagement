/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.VehicleList;
import java.util.Scanner;
import model.InterfaceList;
/**
 *
 * @author trong
 */
public class VehicleManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        boolean temp = true;
        InterfaceList run = new VehicleList();
        Scanner sc = new Scanner(System.in);
        while(temp) {
            System.out.println("=======Vehicle Management=======");
            System.out.println("        0.Add new vehicle       ");
            System.out.println("        1.Check exist Vehicle");
            System.out.println("        2. Update a Vehicle.");
            System.out.println("        3. Remove a Vehicle.");
            System.out.println("        4. Find Vehicle.");
            System.out.println("        5. Display Vehicle list.");
            System.out.println("        6. Save data to file.");
//            System.out.println("        7.Print Vehicle list.");
            System.out.println("        7.Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    run.add();
                    break;
                case 1:
                    run.checkExist();
                    break;
                case 2:
                    run.update(); // bug
                    break;  
                case 3:
                    run.delete();
                    break;
                case 4:
                    run.find();
                    break;
                case 5:
                    run.print();
                    break;
                case 6:
                    run.saveToFile();
                    run.removeAll();
                    break;
//                case 7:
////                    run.print();
//                    break;    
                case 7:
                    temp = false;
                    break;
                default:
                    System.out.println("Please enter number from 0 to 7");
                    break;
            }
        }
    }
    
}
