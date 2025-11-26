package com.rhms;

import com.rhms.models.*;
import com.rhms.services.AlertService;
import com.rhms.services.MonitoringService;

import java.util.Date;

// Remote Health Monitoring System - Main class
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Remote Health Monitoring System (RHMS)");
        System.out.println("Near East University Hospital");
        System.out.println("========================================\n");
        
        AlertService alertService = new AlertService();
        MonitoringService monitoringService = new MonitoringService(alertService);
        
        Doctor doctor = new Doctor("D001", "Dr. Ahmet Demir", "Cardiology");
        System.out.println("Doctor created: " + doctor.toString());
        
        Patient patient1 = new Patient("P001", "Ali Veli", 60, "+905551234567", "Hypertension");
        System.out.println("Patient created: " + patient1.toString());
        
        doctor.addPatient(patient1);
        System.out.println("Doctor assigned to patient.\n");
        WearableDevice smartWatch = new WearableDevice("DEV001", "Smart Watch", "HealthTech Inc.");
        WearableDevice bpMonitor = new WearableDevice("DEV002", "Blood Pressure Monitor", "MedDevice Corp.");
        patient1.addDevice(smartWatch);
        patient1.addDevice(bpMonitor);
        System.out.println("Wearable devices added to patient.\n");
        
        System.out.println("--- Simulation 1: Normal Heart Rate ---");
        HeartRate normalHeartRate = new HeartRate(new Date(), 72);
        monitoringService.receiveVital(patient1, normalHeartRate, doctor);
        
        System.out.println("\n--- Simulation 2: Abnormal Heart Rate (Tachycardia) ---");
        HeartRate abnormalHeartRate = new HeartRate(new Date(), 130);
        monitoringService.receiveVital(patient1, abnormalHeartRate, doctor);
        
        System.out.println("\n--- Simulation 3: High Blood Pressure ---");
        BloodPressure highBP = new BloodPressure(new Date(), 160, 100);
        monitoringService.receiveVital(patient1, highBP, doctor);
        
        System.out.println("\n--- Simulation 4: Normal Body Temperature ---");
        Temperature normalTemp = new Temperature(new Date(), 36.5);
        monitoringService.receiveVital(patient1, normalTemp, doctor);
        
        System.out.println("\n--- Simulation 5: High Fever ---");
        Temperature highTemp = new Temperature(new Date(), 38.8);
        monitoringService.receiveVital(patient1, highTemp, doctor);
        System.out.println("\n\n=== Doctor Reviewing Alerts ===");
        for (Alert alert : doctor.getAlerts()) {
            System.out.println("\nReviewed Alert: " + alert.toString());
            Recommendation recommendation = doctor.reviewAlert(alert);
            System.out.println("Doctor Recommendation: " + recommendation.toString());
        }
        
        System.out.println("\n\n=== Scheduling Follow-up Appointment ===");
        FollowUp followUp = doctor.scheduleFollowUp(patient1, "2024-12-20 14:00", 
                "Follow-up appointment to check patient's vital signs.");
        System.out.println(followUp.toString());
        
        monitoringService.displayPatientVitals(patient1);
        System.out.println("\n\n========================================");
        System.out.println("SYSTEM SUMMARY");
        System.out.println("========================================");
        System.out.println("Total Patients: " + doctor.getPatients().size());
        System.out.println("Total Alerts: " + doctor.getAlerts().size());
        System.out.println("Total Vital Signs: " + patient1.getVitals().size());
        System.out.println("========================================\n");
    }
}

