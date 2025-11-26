package com.rhms.models;

import java.util.Date;

public class Temperature extends VitalSign {
    private double celsius;
    
    private static final double MIN_NORMAL = 36.1;
    private static final double MAX_NORMAL = 37.2;
    
    public Temperature(Date timestamp, double celsius) {
        super(timestamp, "Temperature");
        this.celsius = celsius;
    }
    
    public double getCelsius() {
        return celsius;
    }
    
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
    
    @Override
    public boolean isAbnormal() {
        return celsius < MIN_NORMAL || celsius > MAX_NORMAL;
    }
    
    @Override
    public String getValueAsString() {
        return String.format("%.1f°C", celsius);
    }
    
    @Override
    public String toString() {
        return "Temperature{" +
                "celsius=" + celsius +
                ", timestamp=" + timestamp +
                ", abnormal=" + isAbnormal() +
                '}';
    }
}

