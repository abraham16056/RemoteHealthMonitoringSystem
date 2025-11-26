package com.rhms.models;

public class FollowUp {
    private String followUpId;
    private Patient patient;
    private Doctor doctor;
    private String scheduledDate;
    private String notes;
    private String status;
    
    public FollowUp(Patient patient, Doctor doctor, String scheduledDate, String notes) {
        this.followUpId = "FU" + System.currentTimeMillis();
        this.patient = patient;
        this.doctor = doctor;
        this.scheduledDate = scheduledDate;
        this.notes = notes;
        this.status = "Scheduled";
    }
    
    public String getFollowUpId() {
        return followUpId;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public String getScheduledDate() {
        return scheduledDate;
    }
    
    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "FollowUp{" +
                "followUpId='" + followUpId + '\'' +
                ", patient=" + patient.getName() +
                ", doctor=" + doctor.getName() +
                ", scheduledDate='" + scheduledDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

