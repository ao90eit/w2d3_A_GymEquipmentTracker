package com.aoinc.w2d3_a_gymequipmenttracker.model;

public class GymEquipment {
    private int equipmentID;
    private String itemName;
    private String bodyPart;
    private double price;

    public GymEquipment(String itemName, String bodyPart, double price) {
        this.itemName = itemName;
        this.bodyPart = bodyPart;
        this.price = price;
    }

    public GymEquipment(int equipmentID, String itemName, String bodyPart, double price) {
        this.equipmentID = equipmentID;
        this.itemName = itemName;
        this.bodyPart = bodyPart;
        this.price = price;
    }

    public int getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
