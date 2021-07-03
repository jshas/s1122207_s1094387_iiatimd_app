package com.example.s1122207_s1094387_iiatimd_app;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Prescription {
    @PrimaryKey
    private long prescriptionId;
    private long medicineId;
    private float singleDose; // How many
    private long frequency; // How many doses / per day
    private long interval; // How many hours/minutes between doses

    public Prescription(long prescriptionId, long medicineId, float singleDose, long frequency, long interval ) {
        this.prescriptionId = prescriptionId;
        this.medicineId = medicineId;
        this.singleDose = singleDose;
        this.frequency = frequency;
        this.interval = interval; // in minutes
    }

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    public float getSingleDose() {
        return singleDose;
    }

    public void setSingleDose(float singleDose) {
        this.singleDose = singleDose;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }
}
