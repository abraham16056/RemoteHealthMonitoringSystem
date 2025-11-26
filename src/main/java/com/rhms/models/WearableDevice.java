package com.rhms.models;

public class WearableDevice {
    private String deviceId;
    private String deviceType;
    private String manufacturer;
    private boolean isActive;
    
    public WearableDevice(String deviceId, String deviceType, String manufacturer) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.manufacturer = manufacturer;
        this.isActive = true;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public String getDeviceType() {
        return deviceType;
    }
    
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
    
    @Override
    public String toString() {
        return "WearableDevice{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

