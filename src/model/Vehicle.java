/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author trong
 */
public class Vehicle  implements Serializable ,Comparable<Vehicle> {
    private String idVehicle;
    private String nameVehicle;
    private String colorVehicle;
    private float priceVehicle;
    private String brandVehicle;
    private String typeVehicle;
    private int productYear; 

    public Vehicle(String idVehicle, String nameVehicle, String colorVehicle, float priceVehicle, String brandVehicle, String typeVehicle, int productYear) {
        this.idVehicle = idVehicle;
        this.nameVehicle = nameVehicle;
        this.colorVehicle = colorVehicle;
        this.priceVehicle = priceVehicle;
        this.brandVehicle = brandVehicle;
        this.typeVehicle = typeVehicle;
        this.productYear = productYear;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getColorVehicle() {
        return colorVehicle;
    }

    public void setColorVehicle(String colorVehicle) {
        this.colorVehicle = colorVehicle;
    }

    public float getPriceVehicle() {
        return priceVehicle;
    }

    public void setPriceVehicle(float priceVehicle) {
        this.priceVehicle = priceVehicle;
    }

    public String getBrandVehicle() {
        return brandVehicle;
    }

    public void setBrandVehicle(String brandVehicle) {
        this.brandVehicle = brandVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    @Override
    public String toString() {
        return "idVehicle: " + idVehicle + "|| nameVehicle: " + nameVehicle + "|| colorVehicle: " + colorVehicle + 
        "|| priceVehicle: " + priceVehicle + "|| brandVehicle: " + brandVehicle + "|| typeVehicle: " + typeVehicle + "|| productYear: " + productYear ;
    }

    @Override
    public int compareTo(Vehicle o) {
        return Float.compare(this.getPriceVehicle(), o.getPriceVehicle());
    }
    
    
    
}
