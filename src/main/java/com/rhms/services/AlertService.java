package com.rhms.services;

import com.rhms.models.Alert;
import com.rhms.models.Doctor;
import com.rhms.models.Patient;
import com.rhms.models.VitalSign;

import java.util.ArrayList;
import java.util.List;

public class AlertService {
    private List<Alert> alerts;
    private static int alertCounter = 1;
    
    public AlertService() {
        this.alerts = new ArrayList<>();
    }
    
    public Alert createAlert(Patient patient, VitalSign vitalSign) {
        String severity = determineSeverity(vitalSign);
        String alertId = "ALT" + String.format("%04d", alertCounter++);
        
        Alert alert = new Alert(alertId, patient, vitalSign, severity);
        alerts.add(alert);
        
        Doctor doctor = patient.getAssignedDoctor();
        if (doctor != null) {
            doctor.receiveAlert(alert);
            System.out.println("Alert created for doctor " + doctor.getName() + ": " + alert.getMessage());
        } else {
            System.out.println("WARNING: No assigned doctor found for patient " + patient.getName() + "!");
        }
        
        return alert;
    }
    
    private String determineSeverity(VitalSign vitalSign) {
        if (vitalSign instanceof com.rhms.models.HeartRate) {
            com.rhms.models.HeartRate hr = (com.rhms.models.HeartRate) vitalSign;
            if (hr.getBeatsPerMinute() < 50 || hr.getBeatsPerMinute() > 150) {
                return "High";
            }
            return "Medium";
        } else if (vitalSign instanceof com.rhms.models.BloodPressure) {
            com.rhms.models.BloodPressure bp = (com.rhms.models.BloodPressure) vitalSign;
            if (bp.getSystolic() >= 180 || bp.getDiastolic() >= 120) {
                return "High";
            }
            return "Medium";
        } else if (vitalSign instanceof com.rhms.models.Temperature) {
            com.rhms.models.Temperature temp = (com.rhms.models.Temperature) vitalSign;
            if (temp.getCelsius() < 35.0 || temp.getCelsius() > 38.5) {
                return "High";
            }
            return "Medium";
        }
        return "Medium";
    }
    
    public List<Alert> getAlerts() {
        return alerts;
    }
    
    public Alert getAlertById(String alertId) {
        return alerts.stream()
                .filter(a -> a.getAlertId().equals(alertId))
                .findFirst()
                .orElse(null);
    }
}

