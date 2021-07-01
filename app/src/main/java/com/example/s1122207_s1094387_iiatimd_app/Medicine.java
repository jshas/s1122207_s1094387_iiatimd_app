package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Medicine {


    @PrimaryKey
    private int uuid;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private float amount;
    @ColumnInfo
    private String unit;
    @ColumnInfo
    private int dailyAmount;


    public Medicine(int uuid, String name, float amount, String unit, int dailyAmount) {
        this.uuid = uuid;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.dailyAmount = dailyAmount;
    }




    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDailyAmount() {
        return dailyAmount;
    }

    public void setDailyAmount(int dailyAmount) {
        this.dailyAmount = dailyAmount;
    }
}
