package com.aoinc.w2d3_a_gymequipmenttracker.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GymEquipment implements Parcelable {
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

    protected GymEquipment(Parcel in) {
        equipmentID = in.readInt();
        itemName = in.readString();
        bodyPart = in.readString();
        price = in.readDouble();
    }

    public static final Creator<GymEquipment> CREATOR = new Creator<GymEquipment>() {
        @Override
        public GymEquipment createFromParcel(Parcel in) {
            return new GymEquipment(in);
        }

        @Override
        public GymEquipment[] newArray(int size) {
            return new GymEquipment[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(equipmentID);
        dest.writeString(itemName);
        dest.writeString(bodyPart);
        dest.writeDouble(price);
    }
}
