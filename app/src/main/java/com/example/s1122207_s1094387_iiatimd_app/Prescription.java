package com.example.s1122207_s1094387_iiatimd_app;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Prescription {
    @PrimaryKey
    private int prescriptionId;
    private int medicineId;
    private float singleDose; // How many
    private int frequency; // How many doses / per day
    private int interval; // How many hours/minutes between doses

    public Prescription(int prescriptionId, int medicineId, float singleDose, int frequency, int interval ) {
        this.prescriptionId = prescriptionId;
        this.medicineId = medicineId;
        this.singleDose = singleDose;
        this.frequency = frequency;
        this.interval = interval; // in minutes
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public float getSingleDose() {
        return singleDose;
    }

    public void setSingleDose(float singleDose) {
        this.singleDose = singleDose;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
