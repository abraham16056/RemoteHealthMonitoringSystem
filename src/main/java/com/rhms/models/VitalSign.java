package com.rhms.models;

import java.util.Date;

// Base class for all vital signs
public abstract class VitalSign {
    protected Date timestamp;
    protected String type;
    
    public VitalSign(Date timestamp, String type) {
        this.timestamp = timestamp;
        this.type = type;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public abstract boolean isAbnormal();
    
    public abstract String getValueAsString();
    
    @Override
    public String toString() {
        return "VitalSign{" +
                "type='" + type + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + getValueAsString() +
                ", abnormal=" + isAbnormal() +
                '}';
    }
}

