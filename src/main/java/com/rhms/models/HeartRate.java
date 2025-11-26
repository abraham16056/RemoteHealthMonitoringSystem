package com.rhms.models;

import java.util.Date;

public class HeartRate extends VitalSign {
    private int beatsPerMinute;
    
    private static final int MIN_NORMAL = 60;
    private static final int MAX_NORMAL = 100;
    
    public HeartRate(Date timestamp, int beatsPerMinute) {
        super(timestamp, "Heart Rate");
        this.beatsPerMinute = beatsPerMinute;
    }
    
    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }
    
    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }
    
    @Override
    public boolean isAbnormal() {
        return beatsPerMinute < MIN_NORMAL || beatsPerMinute > MAX_NORMAL;
    }
    
    @Override
    public String getValueAsString() {
        return beatsPerMinute + " bpm";
    }
    
    @Override
    public String toString() {
        return "HeartRate{" +
                "beatsPerMinute=" + beatsPerMinute +
                ", timestamp=" + timestamp +
                ", abnormal=" + isAbnormal() +
                '}';
    }
}

