package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.text.DecimalFormat;

@Entity
public class Medicine {

    @PrimaryKey
    private int uuid;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private double amount;
    @ColumnInfo
    private String unit;
    @ColumnInfo
    private int dailyAmount;

    public Medicine(int uuid, String name, double amount, String unit, int dailyAmount) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        this.amount = Double.parseDouble(formatter.format(amount));
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
