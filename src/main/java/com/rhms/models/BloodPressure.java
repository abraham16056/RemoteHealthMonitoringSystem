package com.rhms.models;

import java.util.Date;

public class BloodPressure extends VitalSign {
    private int systolic;
    private int diastolic;
    
    private static final int NORMAL_SYSTOLIC = 120;
    private static final int NORMAL_DIASTOLIC = 80;
    private static final int HIGH_SYSTOLIC = 130;
    private static final int HIGH_DIASTOLIC = 80;
    
    public BloodPressure(Date timestamp, int systolic, int diastolic) {
        super(timestamp, "Blood Pressure");
        this.systolic = systolic;
        this.diastolic = diastolic;
    }
    
    public int getSystolic() {
        return systolic;
    }
    
    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }
    
    public int getDiastolic() {
        return diastolic;
    }
    
    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }
    
    @Override
    public boolean isAbnormal() {
        return systolic >= HIGH_SYSTOLIC || diastolic >= HIGH_DIASTOLIC;
    }
    
    @Override
    public String getValueAsString() {
        return systolic + "/" + diastolic + " mmHg";
    }
    
    @Override
    public String toString() {
        return "BloodPressure{" +
                "systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", timestamp=" + timestamp +
                ", abnormal=" + isAbnormal() +
                '}';
    }
}

