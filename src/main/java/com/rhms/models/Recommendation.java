package com.rhms.models;

import java.util.Date;

public class Recommendation {
    private String recommendationId;
    private Alert alert;
    private Doctor doctor;
    private String recommendationText;
    private Date timestamp;
    
    public Recommendation(Alert alert, Doctor doctor, String recommendationText) {
        this.recommendationId = "REC" + System.currentTimeMillis();
        this.alert = alert;
        this.doctor = doctor;
        this.recommendationText = recommendationText;
        this.timestamp = new Date();
    }
    
    public String getRecommendationId() {
        return recommendationId;
    }
    
    public Alert getAlert() {
        return alert;
    }
    
    public void setAlert(Alert alert) {
        this.alert = alert;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public String getRecommendationText() {
        return recommendationText;
    }
    
    public void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "Recommendation{" +
                "recommendationId='" + recommendationId + '\'' +
                ", doctor=" + doctor.getName() +
                ", patient=" + alert.getPatient().getName() +
                ", recommendationText='" + recommendationText + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

