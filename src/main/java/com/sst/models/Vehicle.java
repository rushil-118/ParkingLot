package com.sst.models;

public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private String ownerName;
    private VehicleType vehicleType;
    
    public Vehicle(String vehicleNumber, VehicleType vehicleType, String ownerName){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    public String getvehicleNumber() {
        return vehicleNumber;
    }

    public void setvehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
