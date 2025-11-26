package com.rhms.models;

import java.util.Date;

public class Alert {
    private String alertId;
    private Patient patient;
    private VitalSign vitalSign;
    private Date timestamp;
    private String severity;
    private String status;
    private String message;
    
    public Alert(String alertId, Patient patient, VitalSign vitalSign, String severity) {
        this.alertId = alertId;
        this.patient = patient;
        this.vitalSign = vitalSign;
        this.timestamp = new Date();
        this.severity = severity;
        this.status = "Pending";
        this.message = generateMessage();
    }
    
    private String generateMessage() {
        return String.format("Alert: Abnormal value detected for %s. Value: %s",
                patient.getName(), vitalSign.getValueAsString());
    }
    
    public String getAlertId() {
        return alertId;
    }
    
    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public VitalSign getVitalSign() {
        return vitalSign;
    }
    
    public void setVitalSign(VitalSign vitalSign) {
        this.vitalSign = vitalSign;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getSeverity() {
        return severity;
    }
    
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "Alert{" +
                "alertId='" + alertId + '\'' +
                ", patient=" + patient.getName() +
                ", vitalSign=" + vitalSign.getType() +
                ", severity='" + severity + '\'' +
                ", status='" + status + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

