package com.example.s1122207_s1094387_iiatimd_app;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = @ForeignKey(entity = Medicine.class, parentColumns = "medicineId", childColumns = "medicineRefId")
        )
public class Prescription {
    @PrimaryKey
    private long prescriptionId;
    @ColumnInfo(index = true)
    private long medicineRefId;
    private float singleDose; // How many
    private long frequency; // How many doses / per day
    private long interval; // How many hours/minutes between doses

    public Prescription(long prescriptionId, long medicineRefId, float singleDose, long frequency, long interval ) {
        this.prescriptionId = prescriptionId;
        this.medicineRefId = medicineRefId;
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

    public long getMedicineRefId() {
        return medicineRefId;
    }

    public void setMedicineRefId(long medicineId) {
        this.medicineRefId = medicineId;
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
