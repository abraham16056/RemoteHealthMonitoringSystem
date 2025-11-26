package com.rhms.services;

import com.rhms.models.Alert;
import com.rhms.models.Doctor;
import com.rhms.models.Patient;
import com.rhms.models.VitalSign;

public class MonitoringService {
    private AlertService alertService;
    
    public MonitoringService(AlertService alertService) {
        this.alertService = alertService;
    }
    
    public void receiveVital(Patient patient, VitalSign vitalSign, Doctor doctor) {
        if (patient.getAssignedDoctor() == null && doctor != null) {
            doctor.addPatient(patient);
        }
        
        patient.recordVital(vitalSign);
        
        System.out.println("\n=== New Vital Sign Received ===");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Vital Sign: " + vitalSign.toString());
        
        if (vitalSign.isAbnormal()) {
            System.out.println("⚠️  ABNORMAL VALUE DETECTED!");
            Alert alert = alertService.createAlert(patient, vitalSign);
            System.out.println("Alert ID: " + alert.getAlertId());
        } else {
            System.out.println("✓ Value is within normal range.");
        }
    }
    
    public void displayPatientVitals(Patient patient) {
        System.out.println("\n=== " + patient.getName() + " - Vital Signs History ===");
        if (patient.getVitals().isEmpty()) {
            System.out.println("No vital signs recorded yet.");
        } else {
            for (VitalSign vital : patient.getVitals()) {
                System.out.println(vital.toString());
            }
        }
    }
}

