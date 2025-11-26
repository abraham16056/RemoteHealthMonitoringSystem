package com.rhms.models;

import java.util.ArrayList;
import java.util.List;

// Patient class to store patient information
public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String phone;
    private String chronicCondition;
    private List<WearableDevice> devices;
    private List<VitalSign> vitals;
    private Doctor assignedDoctor;
    
    public Patient(String patientId, String name, int age, String phone, String chronicCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.chronicCondition = chronicCondition;
        this.devices = new ArrayList<>();
        this.vitals = new ArrayList<>();
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getChronicCondition() {
        return chronicCondition;
    }
    
    public void setChronicCondition(String chronicCondition) {
        this.chronicCondition = chronicCondition;
    }
    
    public List<WearableDevice> getDevices() {
        return devices;
    }
    
    public void addDevice(WearableDevice device) {
        this.devices.add(device);
    }
    
    public List<VitalSign> getVitals() {
        return vitals;
    }
    
    public void recordVital(VitalSign vital) {
        this.vitals.add(vital);
    }
    
    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }
    
    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }
    
    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", chronicCondition='" + chronicCondition + '\'' +
                ", devices=" + devices.size() +
                ", vitals=" + vitals.size() +
                '}';
    }
}

