/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
//import java.util.List;
import java.util.Scanner;
import model.InterfaceList;
import model.Vehicle;

/**
 *
 * @author trong
 */
public class VehicleList extends ArrayList<Vehicle> implements InterfaceList {
    ArrayList<Vehicle> list = new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    
    public boolean checkIdExist(String a) {
        for(Vehicle v : list){
            if(v.getIdVehicle().equals(a)){
                return true;
            }
        }
        return false;
    }
    
    
    
    public boolean checkBlank(String check){
        if(!check.isEmpty()){
            return true;
        }else
            return false;
    }
    
    
    //0.Add new Vehicle
    public void add() {
        String id,name,color,brand,type;
        int productYear;
        float price;
        boolean keepAdding = true;
        String result;
        while(keepAdding){
            System.out.println("===Adding new vehilce===");
            System.out.print("Please press[Enter] to start");
            sc.nextLine();
            System.out.println("");
            do{
                System.out.print("Enter id : ");
                id =sc.nextLine();
                if(checkIdExist(id)){
                    System.out.print("Values that already exist, please re-enter :");
                }
            }while(checkIdExist(id));
            
            do{
                System.out.print("Enter name :");
                name = sc.nextLine();
            }while(name.isEmpty());
            
            do{
                System.out.print("Enter color :");
                color = sc.nextLine();
            }while(color.isEmpty());
            
            price =Validation.checkPriceUp();
            productYear = Validation.checkProductYearUp();

            do{
                System.out.print("Enter brand :");
                brand = sc.nextLine();
            }while(brand.isEmpty());
            
            do{
                System.out.print("Enter type :");
                type = sc.nextLine();
            }while(type.isEmpty());

//            sc.nextLine();
            Vehicle newVehicle = new Vehicle(id,name,color,price,brand,type,productYear);
            list.add(newVehicle);
            saveToFile();
            System.out.println("Added successfully");
            System.out.print("Do you want to go back to the main menu[Y/N] :");
            result = sc.nextLine();
            if(result.equalsIgnoreCase("y")){
                keepAdding = false;
            }
        }
    }
    //1. Check exist Vehicle
    public void checkExist() {
        boolean keepChecking = true;
        String result;
        boolean flag = true;
        ArrayList<Vehicle> check = readFromFile();
        System.out.print("Please press[Enter] to start");
            sc.nextLine();
        while(keepChecking){
            System.out.print("Enter id to check Exist : ");
            String idCheck = sc.nextLine();
            
            for(Vehicle a : check){
                if(a.getIdVehicle().equalsIgnoreCase(idCheck))
                {
                    flag = false;
                    break;
                }
            }
            
            if(!flag){
                System.out.println("Exist Vehicle");
            }else
                System.out.println("***No Vehicle Found***");
            System.out.print("Do you want to go back to the main menu[Y/N] :");
            result = sc.nextLine();
            
            if(result.equalsIgnoreCase("y")){
                keepChecking = false;
            }
        }
    }
    //3.delete 
    @Override
    public void delete() {
        String idDelete;
        String choice ;
        boolean flag = false;
        System.out.print("Please press[Enter] to start");
            sc.nextLine();
            sc.nextLine();
        System.out.print("Enter id to delete vehicle :");
        idDelete = sc.nextLine();
        ArrayList<Vehicle> check = readFromFile();
        Iterator<Vehicle> iter = check.iterator();
        while (iter.hasNext()) {
            Vehicle v = iter.next();
            if (idDelete.equalsIgnoreCase(v.getIdVehicle())) {
                
                System.out.println("Are you sure you want to delete this vehicle?");
                System.out.println(v.toString());
                System.out.print("Yes-[Y]/No-[N]: ");
                choice = sc.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    iter.remove();  
                    try (FileOutputStream fileOutputStream = new FileOutputStream("src\\data\\Vehicle.dat");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                        flag = true;
                        objectOutputStream.writeObject(check);
                        System.out.println("Vehicle removed successfully");
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("***Failed to delete***");
                    }
                } else {
                    System.out.println("***Vehicle has not been deleted***");
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("***Vehicle does not exist***");
        }
    } 
    
    
    @Override
    public void update() {
        String id ;
        boolean temp = true;
        System.out.print("Please press[Enter] to start");
            sc.nextLine();
        System.out.print("Enter id to update information :");
        id = sc.nextLine();
        ArrayList<Vehicle> listVehicle = readFromFile();
        while(temp){
            if(checkIdExist(id))
            {   
                temp = false;
                for(Vehicle x : listVehicle){
                    if(id.equals(x.getIdVehicle())){
                        System.out.println("==============================================|| The vehi1cle that you to update Information ||==============================================");
                        System.out.println(x.toString());
                    }
                }
                        System.out.print("Enter new name :");
                        String newName = sc.nextLine();

                        System.out.print("Enter new Color :");
                        String newColor = sc.nextLine();
                        System.out.print("Enter new Brand :");
                        String newBrand = sc.nextLine();

                        System.out.print("Enter new type :");
                        String newType = sc.nextLine();
                        
                        float newPrice = Validation.checkPriceUp();
                        int newProductYear = Validation.checkProductYearUp();
                        
//                        System.out.print("Enter new price :");
//                        float newPrice = sc.nextFloat();
//                        System.out.print("Enter new product year :");
//                        int newProductYear = sc.nextInt();

                        ArrayList<Vehicle> check = readFromFile();
                        
                        for(Vehicle vehicle : check ){
                            if(vehicle.getIdVehicle().equalsIgnoreCase(id)){
                                if(!newName.isEmpty()){
                                    vehicle.setNameVehicle(newName);
                                }
                                if(!newColor.isEmpty()){
                                    vehicle.setColorVehicle(newColor);
                                }
                                if(!newBrand.isEmpty()){
                                    vehicle.setBrandVehicle(newBrand);
                                }
                                if(!newType.isEmpty()){
                                    vehicle.setTypeVehicle(newType);
                                }
//                              
                                if(newPrice != 0){
                                    vehicle.setPriceVehicle(newPrice);
                                }
                               
                                
                                if(newProductYear != 0){
                                    vehicle.setProductYear(newProductYear);
                                }
                            }
                        }
                        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\data\\Vehicle.dat");
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

                               objectOutputStream.writeObject(check);
                               System.out.println("Update successfully");
                               objectOutputStream.close();
                               fileOutputStream.close();
                        } catch (IOException e) {
                               e.printStackTrace();
                               System.out.println("Failed to update");
                        }
            }else
            {
                System.out.println("Vehicle does not exist");
                break;
            } 
        }
    }
    

    public ArrayList<Vehicle> readFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream("src\\data\\Vehicle.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            
            list = (ArrayList<Vehicle>)objectInputStream.readObject();
            
        }catch (EOFException errorEof) {
        }catch (FileNotFoundException e) {
        }catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        }
        return list;
    }
    public void saveToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\data\\Vehicle.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            
            objectOutputStream.writeObject(list);
            System.out.println("Saved to file successfully!!!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save to file!!!");
        }
    }
    //5. Print Vehicle list
    @Override
    public void print() {
        System.out.println("Display vehicle list");
        System.out.println("1.Show all list");
        System.out.println("2.Show all(descending by price_vehicle)");
        int choice = sc.nextInt();
        switch(choice){
            case 1: 
                displayAll();
                break;
            case 2:
                displayDescending();
                break;
            default :
                break;
        }
    }
    public void displayAll(){
         ArrayList<Vehicle> vehicleList ;
         vehicleList = readFromFile();
        if(vehicleList.isEmpty()){
            System.out.println("Vehicle List is Empty");
            return;
        }
        for(Vehicle v : vehicleList){
            System.out.println(v.toString());
        }
    }
    public void displayDescending(){
        ArrayList<Vehicle> vehicleList = readFromFile();
        if(vehicleList.isEmpty()){
            System.out.println("Vehicle List is Empty");
            return;
        }
        Collections.sort(vehicleList);
        Collections.reverse(vehicleList);
        for(Vehicle v : vehicleList){
            System.out.println(v.toString());
        }
    }
    //4. Find Vehicle.
    @Override
    public void find() {
        //4.1Searching by id.
        //4.2Searching by name.
        boolean running = true;
        int choice;
        while(running){
        System.out.println("===Searching vehicle===");
        System.out.println("   1.Searching by id  ");
        System.out.println("   2.Searching by name");
        System.out.println("   Any key to back the main menu");
        System.out.print("Please enter your choice : ");
        choice = sc.nextInt();
        switch(choice){
            case 1 :
                searchById();
                break;
            case 2 :
                searchByName();
                break;
            default :
                running = false;
                break;
        }
        }
    }
    public void searchByName(){
        ArrayList<Vehicle> check = readFromFile();
        System.out.print("Please press[Enter] to start");
            sc.nextLine();
        System.out.print("Enter name vehicle : "); 
        String nameSearch = sc.nextLine();
        if(nameSearch.isEmpty()){
            System.out.println("Name is empty");
            return;
        }
        Collections.sort(check);
        Collections.reverse(check);
        for(Vehicle v : check){
            if(v.getNameVehicle().contains(nameSearch)){
                System.out.println(v.toString());
            }
        }
    }
    
    public void searchById(){
        ArrayList<Vehicle> check = readFromFile();
        System.out.print("Please press[Enter] to start");
            sc.nextLine();
            sc.nextLine();
        System.out.print("Enter Id vehicle : "); 
        String idSearch = sc.nextLine();
        if(idSearch.isEmpty()){
            System.out.println("ID is empty");
            return;
        }
        Collections.sort(check);
        Collections.reverse(check);
        for(Vehicle v : check){
            if(v.getIdVehicle().equalsIgnoreCase(idSearch)){
                System.out.println(v.toString());
            }
        }
    }
    @Override
    public void removeAll() {
        this.clear();
    }
    
    //7.Print
    //7.1 print all
    
}

