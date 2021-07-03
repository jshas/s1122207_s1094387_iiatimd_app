package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Medicine {
    @PrimaryKey
    private int medicineId;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private double amount;
    @ColumnInfo
    private String unit;

    public Medicine(int medicineId, String name, double amount, String unit) {
        this.medicineId = medicineId;
        this.name = name;
        this.amount = amount;
        this.unit = unit;

    }
    //Sommige getters en setters kunnen verwijderd worden
    public int getMedicineId() {
            return medicineId;
        }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
