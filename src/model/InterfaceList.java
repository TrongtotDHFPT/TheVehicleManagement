/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author trong
 */
public interface InterfaceList {
  boolean checkIdExist(String a);
    // Find the position of element which has code equal parameter coe
  // add new element( input from scanner) to I_List
  void add(); 
  void delete();
  void update();
  void find();
  void saveToFile();
  
  void print();
  
  void removeAll();

  public void checkExist();

}
