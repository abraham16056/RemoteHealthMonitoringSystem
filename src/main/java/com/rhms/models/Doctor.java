package com.rhms.models;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private List<Patient> patients;
    private List<Alert> alerts;
    
    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
        this.alerts = new ArrayList<>();
    }
    
    public String getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    public List<Patient> getPatients() {
        return patients;
    }
    
    public void addPatient(Patient patient) {
        this.patients.add(patient);
        patient.setAssignedDoctor(this);
    }
    
    public List<Alert> getAlerts() {
        return alerts;
    }
    
    public void receiveAlert(Alert alert) {
        this.alerts.add(alert);
    }
    
    public Recommendation reviewAlert(Alert alert) {
        alert.setStatus("Reviewed");
        String recommendation = "Please visit the hospital or check your medication dosage.";
        return new Recommendation(alert, this, recommendation);
    }
    
    public FollowUp scheduleFollowUp(Patient patient, String date, String notes) {
        return new FollowUp(patient, this, date, notes);
    }
    
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", patients=" + patients.size() +
                ", alerts=" + alerts.size() +
                '}';
    }
}

